package FootballPredictions.Service;

import FootballPredictions.domain.League;
import FootballPredictions.domain.Season;
import FootballPredictions.repository.SeasonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonService {

    private SeasonRepository repository;

    public SeasonService(SeasonRepository repository){ this.repository = repository;}

    public void SaveAllSeasons(List<Season> seasonsList){
        repository.saveAll(seasonsList);
    }
    public void SaveLatestSeason(Season season){ repository.save(season); }

    public List<Season> getAllSeasons() {
        return (List<Season>) this.repository.findAll();
    }
}
