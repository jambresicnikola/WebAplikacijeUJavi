package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.dto.GameDTO;
import hr.tvz.achievementvault.achievementvaultapp.model.Game;
import hr.tvz.achievementvault.achievementvaultapp.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<GameDTO> findAll() {
        return gameRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public Optional<GameDTO> findById(Long id) {
        return gameRepository.findById(id).map(this::mapToDTO);
    }

    @Override
    public List<GameDTO> findByPlatform(String platform) {
        return gameRepository.findByPlatform(platform).stream().map(this::mapToDTO).toList();
    }

    @Override
    public void deleteById(Long id) {
        gameRepository.deleteById(id);
    }

    @Override
    public void save(Game game) {
        gameRepository.save(game);
    }

    private GameDTO mapToDTO(Game game) {
        return GameDTO.builder()
                .title(game.getTitle())
                .platform(game.getPlatform())
                .developer(game.getDeveloper())
                .totalAchievements(game.getTotalAchievements())
                .build();
    }
}
