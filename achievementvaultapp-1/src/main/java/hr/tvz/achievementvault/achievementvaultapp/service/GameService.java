package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.dto.GameDTO;
import hr.tvz.achievementvault.achievementvaultapp.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    List<GameDTO> findAll();
    Optional<GameDTO> findById(Long id);
    List<GameDTO> findByPlatform(String platform);
    void deleteById(Long id);
    void save(Game game);
}
