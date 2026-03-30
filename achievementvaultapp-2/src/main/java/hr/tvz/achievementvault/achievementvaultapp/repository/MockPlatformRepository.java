package hr.tvz.achievementvault.achievementvaultapp.repository;

import hr.tvz.achievementvault.achievementvaultapp.model.Platform;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MockPlatformRepository implements PlatformRepository {
    private final List<Platform> platforms = new ArrayList<>();

    public MockPlatformRepository() {
        platforms.add(new Platform("PlayStation 5", "Sony", 2020));
        platforms.add(new Platform("Xbox Series X", "Microsoft", 2020));
    }

    @Override
    public List<Platform> findAll() {
        return platforms;
    }

    @Override
    public void save(Platform platform) {
        platforms.add(platform);
    }

    @Override
    public Optional<Platform> findByName(String name) {
        return platforms.stream().filter(platform -> platform.getName().equalsIgnoreCase(name)).findFirst();
    }

    @Override
    public boolean existsByName(String name) {
        return platforms.stream().anyMatch(platform -> platform.getName().equalsIgnoreCase(name));
    }
}
