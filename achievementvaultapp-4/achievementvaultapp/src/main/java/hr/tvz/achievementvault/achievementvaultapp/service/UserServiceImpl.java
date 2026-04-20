package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.dto.UserCommand;
import hr.tvz.achievementvault.achievementvaultapp.dto.UserDTO;
import hr.tvz.achievementvault.achievementvaultapp.model.User;
import hr.tvz.achievementvault.achievementvaultapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return userRepository.findByUsername(username).map(this::mapToDTO);
    }

    @Override
    public boolean save(UserCommand command) {
        if (userRepository.existsByUsername(command.getUsername())) {
            return false;
        }

        User user = new User(command.getUsername(), command.getPassword(), command.getEmail());
        userRepository.save(user);

        return true;
    }

    private UserDTO mapToDTO(User user) {
        return new UserDTO(
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        );
    }
}
