package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.dto.GameCommand;
import hr.tvz.achievementvault.achievementvaultapp.dto.GameDTO;

import java.util.List;
import java.util.Optional;

public interface GameService {
    List<GameDTO> findAll();
    Optional<GameDTO> findById(Long id);
    Optional<GameDTO> findByTitle(String title);
    List<GameDTO> findByPlatform(String platform);
    boolean save(GameCommand command);
    boolean deleteByTitle(String title);

    Optional<GameDTO> update(Long id, GameCommand command);
}
