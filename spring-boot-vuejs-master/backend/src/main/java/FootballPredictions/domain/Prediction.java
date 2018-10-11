package FootballPredictions.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Prediction {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
    @ManyToOne
    public Team homeTeam;
    @ManyToOne
    public Team awayTeam;

    public double winPercentageHomeTeam;
    public double winPercentageAwayTeam;
    public double drawPercentage;
}
