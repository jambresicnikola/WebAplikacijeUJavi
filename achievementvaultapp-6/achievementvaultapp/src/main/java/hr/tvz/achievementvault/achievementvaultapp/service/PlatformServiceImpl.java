package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.dto.PlatformDTO;
import hr.tvz.achievementvault.achievementvaultapp.model.Platform;
import hr.tvz.achievementvault.achievementvaultapp.repository.PlatformRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService {

    private final PlatformRepository platformRepository;

    public PlatformServiceImpl(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Override
    public List<PlatformDTO> findByGameId(Long gameId) {
        return platformRepository.findByGameId(gameId).stream()
                .map(this::mapToDTO)
                .toList();
    }

    private PlatformDTO mapToDTO(Platform p) {
        return PlatformDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .manufacturer(p.getManufacturer())
                .releaseYear(p.getReleaseYear())
                .gameId(p.getGame().getId())
                .build();
    }
}