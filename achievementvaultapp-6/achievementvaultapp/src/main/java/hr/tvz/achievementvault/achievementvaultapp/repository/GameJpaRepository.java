package hr.tvz.achievementvault.achievementvaultapp.repository;

import hr.tvz.achievementvault.achievementvaultapp.model.Game;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameJpaRepository extends JpaRepository<Game, Long> {
    Optional<Game> findByTitle(String title);
    List<Game> findByPlatform(String platform);

    @Modifying // Obavezno za custom delete/update
    @Transactional
    void deleteByTitle(String title);
}
