package hr.tvz.achievementvault.achievementvaultapp.repository;

import hr.tvz.achievementvault.achievementvaultapp.model.Game;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Primary
@Repository
public class JdbcGameRepository implements GameRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    private final RowMapper<Game> gameRowMapper = (rs, rowNum) -> {
        Game game = new Game();
        game.setId(rs.getLong("id"));
        game.setTitle(rs.getString("title"));
        game.setPlatform(rs.getString("platform"));
        game.setDeveloper(rs.getString("developer"));
        game.setReleaseYear(rs.getInt("release_year"));
        game.setTotalAchievements(rs.getInt("total_achievements"));
        return game;
    };

    public JdbcGameRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("game")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Game> findAll() {
        return jdbcTemplate.query("SELECT * FROM game", gameRowMapper);
    }

    @Override
    public Optional<Game> findById(Long id) {
        List<Game> results = jdbcTemplate.query(
                "SELECT * FROM game WHERE id = ?", gameRowMapper, id);
        return results.stream().findFirst();
    }

    @Override
    public Optional<Game> findByTitle(String title) {
        List<Game> results = jdbcTemplate.query(
                "SELECT * FROM game WHERE title = ?", gameRowMapper, title);
        return results.stream().findFirst();
    }

    @Override
    public List<Game> findByPlatform(String platform) {
        return jdbcTemplate.query(
                "SELECT * FROM game WHERE platform = ?", gameRowMapper, platform);
    }

    @Override
    public Game save(Game game) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", game.getTitle());
        params.put("platform", game.getPlatform());
        params.put("developer", game.getDeveloper());
        params.put("release_year", game.getReleaseYear());
        params.put("total_achievements", game.getTotalAchievements());

        Number generatedId = simpleJdbcInsert.executeAndReturnKey(params);
        game.setId(generatedId.longValue());
        return game;
    }

    @Override
    public boolean existsByTitle(String title) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM game WHERE title = ?", Integer.class, title);
        return count != null && count > 0;
    }

    @Override
    public int deleteByTitle(String title) {
        return jdbcTemplate.update("DELETE FROM game WHERE title = ?", title);
    }

    @Override
    public Game update(Long id, Game game) {
        jdbcTemplate.update(
                "UPDATE game SET title = ?, platform = ?, developer = ?, " +
                        "release_year = ?, total_achievements = ? WHERE id = ?",
                game.getTitle(),
                game.getPlatform(),
                game.getDeveloper(),
                game.getReleaseYear(),
                game.getTotalAchievements(),
                id
        );
        return game;
    }
}