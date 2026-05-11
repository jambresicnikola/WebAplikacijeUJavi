package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.dto.GameCommand;
import hr.tvz.achievementvault.achievementvaultapp.dto.GameDTO;
import hr.tvz.achievementvault.achievementvaultapp.model.Game;
import hr.tvz.achievementvault.achievementvaultapp.repository.GameJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GameServiceImpl implements GameService {

    private final GameJpaRepository gameRepository;

    public GameServiceImpl(GameJpaRepository gameRepository) {
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
    public Optional<GameDTO> findByTitle(String title) {
        return gameRepository.findByTitle(title).map(this::mapToDTO);
    }

    @Override
    public List<GameDTO> findByPlatform(String platform) {
        return gameRepository.findByPlatform(platform).stream().map(this::mapToDTO).toList();
    }

    @Override
    @Transactional
    public boolean save(GameCommand command) {
        if (gameRepository.findByTitle(command.getTitle()).isPresent()) {
            return false;
        }

        Game game = new Game();
        game.setTitle(command.getTitle());
        game.setPlatform(command.getPlatform());
        game.setDeveloper(command.getDeveloper());
        game.setReleaseYear(command.getReleaseYear());
        game.setTotalAchievements(command.getTotalAchievements());

        gameRepository.save(game);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteByTitle(String title) {
        if (gameRepository.findByTitle(title).isPresent()) {
            gameRepository.deleteByTitle(title);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Optional<GameDTO> update(Long id, GameCommand command) {
        return gameRepository.findById(id).map(game -> {
            game.setTitle(command.getTitle());
            game.setPlatform(command.getPlatform());
            game.setDeveloper(command.getDeveloper());
            game.setReleaseYear(command.getReleaseYear());
            game.setTotalAchievements(command.getTotalAchievements());

            Game updatedGame = gameRepository.save(game);

            return mapToDTO(updatedGame);
        });
    }

    private GameDTO mapToDTO(Game game) {
        return GameDTO.builder()
                .id(game.getId())
                .title(game.getTitle())
                .platform(game.getPlatform())
                .releaseYear(game.getReleaseYear())
                .developer(game.getDeveloper())
                .totalAchievements(game.getTotalAchievements())
                .build();
    }
}
