package hr.tvz.achievementvault.achievementvaultapp.controller;

import hr.tvz.achievementvault.achievementvaultapp.dto.AchievementCommand;
import hr.tvz.achievementvault.achievementvaultapp.dto.AchievementDTO;
import hr.tvz.achievementvault.achievementvaultapp.service.AchievementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
public class AchievementController {
    private final AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping
    public List<AchievementDTO> getAchievements() {
        return achievementService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody AchievementCommand command) {
        boolean saved = achievementService.save(command);

        if (!saved) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
