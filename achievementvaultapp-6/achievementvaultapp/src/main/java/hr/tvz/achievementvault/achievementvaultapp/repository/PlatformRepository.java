package hr.tvz.achievementvault.achievementvaultapp.repository;

import hr.tvz.achievementvault.achievementvaultapp.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {
    List<Platform> findByGameId(Long gameId);
}