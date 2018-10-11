package FootballPredictions.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Season {
    @Id
    public Long id;
    @ManyToOne
    public League league;

    public String name;

    public Season(Long id, League league, String name) {
        this.id = id;
        this.league = league;
        this.name = name;
    }
}
