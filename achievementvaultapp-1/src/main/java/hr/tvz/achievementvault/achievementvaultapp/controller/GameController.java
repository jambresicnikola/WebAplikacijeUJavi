package hr.tvz.achievementvault.achievementvaultapp.controller;

import hr.tvz.achievementvault.achievementvaultapp.dto.GameDTO;
import hr.tvz.achievementvault.achievementvaultapp.model.Game;
import hr.tvz.achievementvault.achievementvaultapp.service.GameService;
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
    public List<GameDTO> getGames() {
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getById(@PathVariable Long id) {
        return gameService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/platform/{platform}")
    public List<GameDTO> getByPlatform(@PathVariable String platform) {
        return gameService.findByPlatform(platform);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        gameService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Game game) {
        gameService.save(game);
    }
}
