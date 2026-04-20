package hr.tvz.achievementvault.achievementvaultapp.dto;

import lombok.Builder;

@Builder
public record GameDTO(Long id,
                      String title,
                      String platform,
                      String developer,
                      Integer releaseYear,
                      Integer totalAchievements,
                      Integer unlockedCount,
                      Double completionPercent) {
}
