package hr.tvz.achievementvault.achievementvaultapp.repository;

import hr.tvz.achievementvault.achievementvaultapp.model.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MockGameRepository implements GameRepository {

    private final List<Game> games = new ArrayList<>();

    public MockGameRepository() {
        games.add(new Game(1L, "The Witcher 3", "PC", "CD Projekt Red", 2015, 78));
        games.add(new Game(2L, "Elden Ring", "PS5", "FromSoftware", 2022, 42));
        games.add(new Game(3L, "Hades", "PC", "Supergiant Games", 2020, 50));
        games.add(new Game(4L, "God of War", "PS5", "Santa Monica Studio", 2018, 37));
        games.add(new Game(5L, "Hollow Knight", "PC", "Team Cherry", 2017, 63));
        games.add(new Game(6L, "Cyberpunk 2077", "PC", "CD Projekt Red", 2020, 52));
        games.add(new Game(7L, "Demon's Souls", "PS5", "Bluepoint Games", 2020, 35));
    }

    @Override
    public List<Game> findAll() {
        return games;
    }

    @Override
    public Optional<Game> findById(Long id) {
        return games.stream().filter(game -> game.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Game> findByTitle(String title) {
        return games.stream().filter(game -> game.getTitle().equalsIgnoreCase(title)).findFirst();
    }

    @Override
    public List<Game> findByPlatform(String platform) {
        return games.stream().filter(game -> game.getPlatform().equalsIgnoreCase(platform)).toList();
    }

    @Override
    public void save(Game game) {
        if (game.getId() != null) {
            for (int i = 0; i < games.size(); i++) {
                if (games.get(i).getId().equals(game.getId())) {
                    games.set(i, game);
                    return;
                }
            }
        }

        game.setId((long) (games.size() + 1));
        games.add(game);
    }

    @Override
    public boolean existsByTitle(String title) {
        return games.stream().anyMatch(game -> game.getTitle().equalsIgnoreCase(title));
    }

    @Override
    public void deleteByTitle(String title) {
        games.removeIf(game -> game.getTitle().equalsIgnoreCase(title));
    }
}
