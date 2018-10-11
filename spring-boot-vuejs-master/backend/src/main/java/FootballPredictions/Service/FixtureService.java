package FootballPredictions.Service;

import FootballPredictions.domain.Fixture;
import FootballPredictions.repository.FixtureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FixtureService {
    @Autowired
    private FixtureRepository repository;

    public FixtureService(FixtureRepository repository){
        this.repository =  repository;
    }

    public List<Fixture> getAllFixtures(){
        return (List<Fixture>) this.repository.findAll();
    }

    public void saveAllFixtures(List<Fixture> fixtures){
        repository.saveAll(fixtures);
    }
}
