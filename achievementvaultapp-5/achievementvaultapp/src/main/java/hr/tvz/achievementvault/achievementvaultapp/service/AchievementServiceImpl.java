package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.dto.AchievementCommand;
import hr.tvz.achievementvault.achievementvaultapp.dto.AchievementDTO;
import hr.tvz.achievementvault.achievementvaultapp.model.Achievement;
import hr.tvz.achievementvault.achievementvaultapp.repository.AchievementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AchievementServiceImpl implements  AchievementService {
    private final AchievementRepository achievementRepository;

    public AchievementServiceImpl(AchievementRepository achievementRepository) {
        this.achievementRepository = achievementRepository;
    }

    @Override
    public List<AchievementDTO> findAll() {
        return achievementRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public Optional<AchievementDTO> findByName(String name) {
        return achievementRepository.findByName(name).map(this::mapToDTO);
    }

    @Override
    public boolean save(AchievementCommand command) {
        if (achievementRepository.existsByName(command.getName())) {
            return false;
        }

        Achievement achievement = new Achievement(
                command.getName(),
                command.getPoints(),
                command.getCategory()
        );

        achievementRepository.save(achievement);

        return true;
    }

    private AchievementDTO mapToDTO(Achievement achievement) {
        return new AchievementDTO(
                achievement.getName(),
                achievement.getPoints(),
                achievement.getCategory()
        );
    }
}
