package FootballPredictions.Service;

import FootballPredictions.domain.Game;
import FootballPredictions.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    public GameService(GameRepository repository){
        this.repository =  repository;
    }

    public List<Game> getAllGames(){

        return (List<Game>) this.repository.findAll();
    }
}
