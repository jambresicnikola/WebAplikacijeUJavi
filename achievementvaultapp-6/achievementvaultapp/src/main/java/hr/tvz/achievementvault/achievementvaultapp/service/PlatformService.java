package hr.tvz.achievementvault.achievementvaultapp.service;

import hr.tvz.achievementvault.achievementvaultapp.dto.PlatformDTO;

import java.util.List;

public interface PlatformService {
    List<PlatformDTO> findByGameId(Long gameId);
}