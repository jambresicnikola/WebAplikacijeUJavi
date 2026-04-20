package hr.tvz.achievementvault.achievementvaultapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserCommand {
    @NotBlank(message = "Korisničko ime ne smije biti prazno.")
    private String username;

    @NotBlank(message = "Lozinka je obavezna.")
    private String password;

    @Email(message = "Mora biti valjana e-mail adresa.")
    private String email;
}
