package FootballPredictions.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Team {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String league;

    public Team(String name, String country, String league) {
        this.name = name;
        this.country = country;
        this.league = league;
    }
}
