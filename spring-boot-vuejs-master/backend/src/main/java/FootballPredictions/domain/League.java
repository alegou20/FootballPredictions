package FootballPredictions.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class League {
    @Id
    private Long leagueId;
    private String name;

    public League(Long leagueId, String name) {
        this.leagueId = leagueId;
        this.name = name;
    }
}
