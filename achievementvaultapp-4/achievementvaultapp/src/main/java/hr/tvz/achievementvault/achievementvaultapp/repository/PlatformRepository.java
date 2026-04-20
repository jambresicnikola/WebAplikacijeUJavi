package hr.tvz.achievementvault.achievementvaultapp.repository;

import hr.tvz.achievementvault.achievementvaultapp.model.Platform;

import java.util.List;
import java.util.Optional;

public interface PlatformRepository {
    List<Platform> findAll();
    void save(Platform platform);
    Optional<Platform> findByName(String name);
    boolean existsByName(String name);
}
