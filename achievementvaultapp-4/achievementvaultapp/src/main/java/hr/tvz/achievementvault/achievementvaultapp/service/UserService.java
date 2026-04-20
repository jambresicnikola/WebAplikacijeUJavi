package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.dto.UserCommand;
import hr.tvz.achievementvault.achievementvaultapp.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAll();
    Optional<UserDTO> findByUsername(String username);
    boolean save(UserCommand command);
}
