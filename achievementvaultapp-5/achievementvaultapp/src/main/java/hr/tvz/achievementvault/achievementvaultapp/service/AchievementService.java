package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.dto.AchievementCommand;
import hr.tvz.achievementvault.achievementvaultapp.dto.AchievementDTO;

import java.util.List;
import java.util.Optional;

public interface AchievementService {
    List<AchievementDTO> findAll();
    Optional<AchievementDTO> findByName(String name);
    boolean save(AchievementCommand command);
}
