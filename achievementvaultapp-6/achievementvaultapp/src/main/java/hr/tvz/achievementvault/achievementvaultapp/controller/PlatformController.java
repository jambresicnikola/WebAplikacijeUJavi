package hr.tvz.achievementvault.achievementvaultapp.controller;

import hr.tvz.achievementvault.achievementvaultapp.dto.PlatformDTO;
import hr.tvz.achievementvault.achievementvaultapp.service.PlatformService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platforms")
@CrossOrigin(origins = "http://localhost:5173")
public class PlatformController {

    private final PlatformService platformService;

    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @GetMapping("/game/{gameId}")
    public List<PlatformDTO> getByGameId(@PathVariable Long gameId) {
        return platformService.findByGameId(gameId);
    }
}