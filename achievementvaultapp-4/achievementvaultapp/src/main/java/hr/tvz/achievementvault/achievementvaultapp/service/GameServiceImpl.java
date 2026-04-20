package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.dto.GameCommand;
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
    public Optional<GameDTO> findByTitle(String title) {
        return gameRepository.findByTitle(title).map(this::mapToDTO);
    }

    @Override
    public List<GameDTO> findByPlatform(String platform) {
        return gameRepository.findByPlatform(platform).stream().map(this::mapToDTO).toList();
    }

    @Override
    public boolean save(GameCommand command) {
        if (gameRepository.existsByTitle(command.getTitle())) {
            return false;
        }

        Game game = new Game(
                (long) (gameRepository.findAll().size() + 1),
                command.getTitle(),
                command.getPlatform(),
                command.getDeveloper(),
                command.getReleaseYear(),
                command.getTotalAchievements()
        );

        gameRepository.save(game);

        return true;
    }

    @Override
    public boolean deleteByTitle(String title) {
        if (!gameRepository.existsByTitle(title)) {
            return false;
        }

        gameRepository.deleteByTitle(title);

        return true;
    }

    @Override
    public Optional<GameDTO> update(Long id, GameCommand command) {
        return gameRepository.findById(id).map(game -> {

            game.setTitle(command.getTitle());
            game.setPlatform(command.getPlatform());
            game.setDeveloper(command.getDeveloper());
            game.setReleaseYear(command.getReleaseYear());
            game.setTotalAchievements(command.getTotalAchievements());

            gameRepository.save(game);

            return GameDTO.builder()
                    .id(game.getId())
                    .title(game.getTitle())
                    .platform(game.getPlatform())
                    .releaseYear(game.getReleaseYear())
                    .developer(game.getDeveloper())
                    .totalAchievements(game.getTotalAchievements())
                    .unlockedCount(0)
                    .completionPercent(0.0)
                    .build();
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
