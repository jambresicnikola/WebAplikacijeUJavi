package hr.tvz.achievementvault.achievementvaultapp.repository;

import hr.tvz.achievementvault.achievementvaultapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();
    void save(User user);
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
