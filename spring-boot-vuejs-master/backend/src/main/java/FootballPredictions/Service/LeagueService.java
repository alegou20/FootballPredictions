package FootballPredictions.Service;

import FootballPredictions.domain.Game;
import FootballPredictions.domain.League;
import FootballPredictions.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LeagueService {
    @Autowired
    private LeagueRepository repository;

    public LeagueService(LeagueRepository repository){ this.repository = repository;}

    public void SaveAllLeagues(List<League> leaguesList){
        repository.saveAll(leaguesList);
    }

    public Optional<League> FindById(Long id){
        return repository.findById(id);
    }

    public List<League> getAllLeagues() {
        return (List<League>) this.repository.findAll();
    }
}
