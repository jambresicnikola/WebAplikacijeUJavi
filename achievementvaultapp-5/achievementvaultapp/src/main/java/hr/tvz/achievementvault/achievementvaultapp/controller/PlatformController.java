package hr.tvz.achievementvault.achievementvaultapp.controller;

import hr.tvz.achievementvault.achievementvaultapp.dto.PlatformCommand;
import hr.tvz.achievementvault.achievementvaultapp.dto.PlatformDTO;
import hr.tvz.achievementvault.achievementvaultapp.service.PlatformService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platforms")
public class PlatformController {
    private final PlatformService  platformService;

    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @GetMapping
    public List<PlatformDTO> getGames() {
        return platformService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PlatformCommand command) {
        boolean saved = platformService.save(command);

        if (!saved) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
