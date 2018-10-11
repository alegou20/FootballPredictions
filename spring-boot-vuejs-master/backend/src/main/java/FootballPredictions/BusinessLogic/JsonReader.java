package FootballPredictions.BusinessLogic;

import FootballPredictions.Service.FixtureService;
import FootballPredictions.Service.LeagueService;
import FootballPredictions.Service.SeasonService;
import FootballPredictions.domain.Fixture;
import FootballPredictions.domain.League;
import FootballPredictions.domain.Season;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class JsonReader {
    @Autowired
    private FixtureService fixtureService;
    private LeagueService leagueService;
    private SeasonService seasonService;

    public JsonReader(FixtureService fixtureService, LeagueService leagueService, SeasonService seasonService){
        this.fixtureService = fixtureService;
        this.leagueService = leagueService;
        this.seasonService = seasonService;
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public void GetAllFixturesBetweenDates() throws IOException, JSONException, ParseException {
        JSONObject json = readJsonFromUrl("https://soccer.sportmonks.com/api/v2.0/fixtures/date/2018-10-6?api_token=29fYhCVmPwlqukRaFCV8y8tkzJYARiMDoD6B6AzgyA7emOGZIH8LVgCJZh2S");
        //retrieving the jsonArray in data
        JSONArray jsonArray = json.getJSONArray("data");
        List<Fixture> fixtures = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //for every fixture in fixtures
        for(int i = 0; i < jsonArray.length(); i++){
            //retrieving needed fixture data
            JSONObject obj = jsonArray.getJSONObject(i);
            //casting fixture data to domain model
            Long visitorTeamId = new Long((int) obj.get("visitorteam_id"));
            Long localTeamId = new Long((int) obj.get("localteam_id"));
            Long leagueId = new Long((int) obj.get("league_id"));
            String dateString = (String) obj.getJSONObject("time").getJSONObject("starting_at").get("date");
            Date date = sdf.parse(dateString);
            Fixture fixture = new Fixture(visitorTeamId,localTeamId,leagueId,date);
            fixtures.add(fixture);
        }
        fixtureService.saveAllFixtures(fixtures);
    }

    public void GetAllLeagues() throws IOException, JSONException{
        JSONObject json = readJsonFromUrl("https://soccer.sportmonks.com/api/v2.0/leagues?api_token=29fYhCVmPwlqukRaFCV8y8tkzJYARiMDoD6B6AzgyA7emOGZIH8LVgCJZh2S");
        JSONArray jsonArray = json.getJSONArray("data");
        List<League> leagues = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            Long leagueId = new Long((int) obj.get("id"));
            String leagueName = (String) obj.get("name");
            League league = new League(leagueId,leagueName);
            leagues.add(league);
        }
        leagueService.SaveAllLeagues(leagues);
    }

    public void GetAllSeasons() throws IOException, JSONException{
        JSONObject json = readJsonFromUrl("https://soccer.sportmonks.com/api/v2.0/seasons?api_token=29fYhCVmPwlqukRaFCV8y8tkzJYARiMDoD6B6AzgyA7emOGZIH8LVgCJZh2S");
        JSONArray jsonArray = json.getJSONArray("data");
        List<Season> seasons = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            Long seasonId = new Long((int) obj.get("id"));
            String seasonName = (String) obj.get("name");
            Long leagueId = new Long((int) obj.get("league_id"));
            Optional<League> fetchedLeague = leagueService.FindById(leagueId);
            //if the league is present in the database create a new season
            if(fetchedLeague.isPresent()){
                Season season = new Season(seasonId,fetchedLeague.get(),seasonName);
                seasons.add(season);
            }
            //TO DO
            //exception when season cant be created because there is no corresponding league present.
        }
        seasonService.SaveAllSeasons(seasons);
    }
}
