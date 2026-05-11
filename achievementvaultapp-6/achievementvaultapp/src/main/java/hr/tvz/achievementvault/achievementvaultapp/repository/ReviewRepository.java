package hr.tvz.achievementvault.achievementvaultapp.repository;

import hr.tvz.achievementvault.achievementvaultapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByGameId(Long gameId);

    @Query("SELECT r FROM Review r JOIN r.game g WHERE g.title = :title")
    List<Review> findByGameTitle(@Param("title") String title);

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.game.id = :gameId")
    Double findAverageRatingByGameId(@Param("gameId") Long gameId);
}