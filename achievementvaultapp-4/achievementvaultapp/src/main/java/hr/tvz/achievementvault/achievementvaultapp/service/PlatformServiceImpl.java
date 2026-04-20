package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.dto.PlatformCommand;
import hr.tvz.achievementvault.achievementvaultapp.dto.PlatformDTO;
import hr.tvz.achievementvault.achievementvaultapp.model.Platform;
import hr.tvz.achievementvault.achievementvaultapp.repository.PlatformRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformServiceImpl implements PlatformService {
    private final PlatformRepository platformRepository;

    public PlatformServiceImpl(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Override
    public List<PlatformDTO> findAll() {
        return platformRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    @Override
    public Optional<PlatformDTO> findByName(String name) {
        return platformRepository.findByName(name).map(this::mapToDTO);
    }

    @Override
    public boolean save(PlatformCommand command) {
        if (platformRepository.existsByName(command.getName())) {
            return false;
        }

        Platform platform = new Platform(
                command.getName(),
                command.getManufacturer(),
                command.getReleaseYear());

        platformRepository.save(platform);

        return true;
    }

    private PlatformDTO mapToDTO(Platform platform) {
        return new PlatformDTO(
                platform.getName(),
                platform.getManufacturer(),
                platform.getReleaseYear()
        );
    }
}
