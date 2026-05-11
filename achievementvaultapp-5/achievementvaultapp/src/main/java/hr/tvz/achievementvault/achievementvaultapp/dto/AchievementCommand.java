package hr.tvz.achievementvault.achievementvaultapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AchievementCommand {
    @NotBlank(message = "Naziv achievementa je obavezan.")
    private String name;

    @Positive(message = "Broj bodova mora biti pozitivan broj.")
    private Integer points;

    @NotBlank(message = "Naziv kategorije je obavezan.")
    private String category;
}
