package hr.tvz.achievementvault.achievementvaultapp.dto;

import lombok.Builder;

@Builder
public record PlatformDTO(
        Long id,
        String name,
        String manufacturer,
        int releaseYear,
        Long gameId) {
}
