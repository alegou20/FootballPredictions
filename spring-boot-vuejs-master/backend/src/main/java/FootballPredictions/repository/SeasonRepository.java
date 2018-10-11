package FootballPredictions.repository;

import FootballPredictions.domain.Season;
import org.springframework.data.repository.CrudRepository;

public interface SeasonRepository extends CrudRepository<Season, Long> {
}
