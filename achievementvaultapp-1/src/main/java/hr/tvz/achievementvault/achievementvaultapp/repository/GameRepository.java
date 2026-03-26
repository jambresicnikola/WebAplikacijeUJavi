package hr.tvz.achievementvault.achievementvaultapp.repository;

import hr.tvz.achievementvault.achievementvaultapp.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameRepository {
    List<Game> findAll();
    Optional<Game> findById(Long id);
    Optional<Game> findByTitle(String title);
    List<Game> findByPlatform(String platform);
    void deleteById(Long id);
    void save(Game game);
}
