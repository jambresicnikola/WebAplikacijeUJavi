package hr.tvz.achievementvault.achievementvaultapp.controller;

import hr.tvz.achievementvault.achievementvaultapp.dto.UserCommand;
import hr.tvz.achievementvault.achievementvaultapp.dto.UserDTO;
import hr.tvz.achievementvault.achievementvaultapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody UserCommand command) {
        boolean saved = userService.save(command);

        if (!saved) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
