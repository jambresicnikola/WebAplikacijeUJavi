package hr.tvz.achievementvault.achievementvaultapp.repository;

import hr.tvz.achievementvault.achievementvaultapp.model.Achievement;

import java.util.List;
import java.util.Optional;

public interface AchievementRepository {
    List<Achievement> findAll();
    void save(Achievement achievement);
    Optional<Achievement> findByName(String name);
    boolean existsByName(String name);
}
