package hr.tvz.achievementvault.achievementvaultapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class GameCommand {
    @NotBlank(message = "Title cannot be empty.")
    private String title;

    @NotBlank(message = "Platform cannot be empty.")
    private String platform;

    @NotBlank(message = "Developer cannot be empty.")
    private String developer;

    @Min(value = 1970, message = "Release year cannot be lower than 1970.")
    @Max(value = 2030, message = "Release year cannot be higher than 2030.")
    private Integer releaseYear;

    @Positive(message = "Total achievements must be a positive number.")
    private Integer totalAchievements;
}
