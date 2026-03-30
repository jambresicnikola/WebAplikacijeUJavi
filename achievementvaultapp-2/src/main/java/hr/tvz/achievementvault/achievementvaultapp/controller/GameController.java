package hr.tvz.achievementvault.achievementvaultapp.controller;

import hr.tvz.achievementvault.achievementvaultapp.dto.GameCommand;
import hr.tvz.achievementvault.achievementvaultapp.dto.GameDTO;
import hr.tvz.achievementvault.achievementvaultapp.service.GameService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameDTO> getGames(@RequestParam(required = false) String platform) {
        if (platform != null) {
            return gameService.findByPlatform(platform);
        }

        return gameService.findAll();
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<GameDTO> getByTitle(@PathVariable String title) {
        return gameService.findByTitle(title)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<GameDTO> getById(@PathVariable Long id) {
        return gameService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody GameCommand command) {
        boolean saved = gameService.save(command);

        if (!saved) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<Void> deleteByTitle(@PathVariable String title) {
        boolean deleted = gameService.deleteByTitle(title);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
