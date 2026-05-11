package hr.tvz.achievementvault.achievementvaultapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PlatformCommand {
    @NotBlank(message = "Naziv platforme ne smije biti prazan.")
    private String name;

    @NotBlank(message = "Proizvođač je obavezan.")
    private String manufacturer;

    @Min(value = 1970, message = "Godina izlaska ne može biti prije 1970.")
    @Max(value = 2030, message = "Godina izlaska ne može biti nakon 2030.")
    private Integer releaseYear;
}
