package FootballPredictions.controller;

import FootballPredictions.BusinessLogic.JsonReader;
import FootballPredictions.Service.FixtureService;
import FootballPredictions.Service.GameService;
import FootballPredictions.Service.LeagueService;
import FootballPredictions.Service.SeasonService;
import FootballPredictions.domain.Fixture;
import FootballPredictions.domain.Game;
import FootballPredictions.domain.League;
import FootballPredictions.domain.Season;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
public class HomeController {
//    @Autowired
//    private final GameService gameService;
//    private final FixtureService fixtureService;
//    private final LeagueService leagueService;
//    private final SeasonService seasonService;
//
//    public HomeController(GameService gameService, FixtureService fixtureService, LeagueService leagueService, SeasonService seasonService){
//        this.fixtureService = fixtureService;
//        this.leagueService = leagueService;
//        this.gameService = gameService;
//        this.seasonService = seasonService;
//    }
//
//    @GetMapping(value = "")
//    public List<Game> getMatches() {
//        return gameService.getAllGames();
//    }
//
//    @GetMapping(value="getfixtures")
//    public List<Fixture> getFixtures() throws JSONException, ParseException, IOException {
//        JsonReader reader = new JsonReader(fixtureService, leagueService, seasonService);
//        reader.GetAllFixturesBetweenDates();
//        return fixtureService.getAllFixtures();
//    }
//
//    @GetMapping(value="getleagues")
//    public List<League> getLeagues() throws JSONException, ParseException, IOException {
//        JsonReader reader = new JsonReader(fixtureService, leagueService, seasonService);
//        reader.GetAllLeagues();
//        return leagueService.getAllLeagues();
//    }
//
//    @GetMapping(value="getseasons")
//    public List<Season> getSeasons() throws JSONException, ParseException, IOException {
//        JsonReader reader = new JsonReader(fixtureService, leagueService, seasonService);
//        reader.GetAllSeasons();
//        return seasonService.getAllSeasons();
//    }
}
