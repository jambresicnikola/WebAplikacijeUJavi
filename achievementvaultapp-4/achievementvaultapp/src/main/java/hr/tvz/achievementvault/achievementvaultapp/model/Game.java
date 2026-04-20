package hr.tvz.achievementvault.achievementvaultapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private Long id;
    private String title;
    private String platform;
    private String developer;
    private Integer releaseYear;
    private Integer totalAchievements;
}
