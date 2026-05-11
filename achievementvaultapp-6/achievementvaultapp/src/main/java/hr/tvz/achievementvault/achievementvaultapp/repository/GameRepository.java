package hr.tvz.achievementvault.achievementvaultapp.repository;

import hr.tvz.achievementvault.achievementvaultapp.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameRepository {
    List<Game> findAll();
    Optional<Game> findById(Long id);
    Optional<Game> findByTitle(String title);
    List<Game> findByPlatform(String platform);
    Game save(Game game);
    boolean existsByTitle(String title);
    int deleteByTitle(String title);
    Game update(Long id, Game game);
}
