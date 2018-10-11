package FootballPredictions.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Fixture {
    @Id
    private Long id;
    private Long VisitorTeamId;
    private Long HomeTeamId;
    private Long LeagueId;
    private Date date;


    public Fixture(Long visitorTeamId, Long homeTeamId, Long leagueId, Date date) {
        VisitorTeamId = visitorTeamId;
        HomeTeamId = homeTeamId;
        LeagueId = leagueId;
        this.date = date;
    }
}
