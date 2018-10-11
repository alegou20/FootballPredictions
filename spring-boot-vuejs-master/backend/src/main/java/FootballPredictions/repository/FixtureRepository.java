package FootballPredictions.repository;

import FootballPredictions.domain.Fixture;
import org.springframework.data.repository.CrudRepository;

public interface FixtureRepository extends CrudRepository<Fixture, Long> {
}
