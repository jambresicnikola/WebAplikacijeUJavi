package hr.tvz.achievementvault.achievementvaultapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Achievement {
    private String name;
    private Integer points;
    private String category;
}
