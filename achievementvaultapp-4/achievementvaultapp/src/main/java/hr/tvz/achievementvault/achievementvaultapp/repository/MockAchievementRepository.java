package hr.tvz.achievementvault.achievementvaultapp.repository;

import hr.tvz.achievementvault.achievementvaultapp.model.Achievement;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MockAchievementRepository implements AchievementRepository {
    private final List<Achievement> achievements = new ArrayList<>();

    public MockAchievementRepository() {
        achievements.add(new Achievement("Reached the ending 'Elden Lord'.", 20, "GOLD"));
        achievements.add(new Achievement("Defeated Shardbearer Morgott.", 20, "SILVER"));
    }

    @Override
    public List<Achievement> findAll() {
        return achievements;
    }

    @Override
    public void save(Achievement achievement) {
        achievements.add(achievement);
    }

    @Override
    public Optional<Achievement> findByName(String name) {
        return achievements.stream().filter(achievement -> achievement.getName().equals(name)).findFirst();
    }

    @Override
    public boolean existsByName(String name) {
        return achievements.stream().anyMatch(achievement -> achievement.getName().equals(name));
    }
}
