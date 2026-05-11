package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.dto.PlatformCommand;
import hr.tvz.achievementvault.achievementvaultapp.dto.PlatformDTO;

import java.util.List;
import java.util.Optional;

public interface PlatformService {
    List<PlatformDTO> findAll();
    Optional<PlatformDTO> findByName(String name);
    boolean save(PlatformCommand command);
}
