package hr.tvz.achievementvault.achievementvaultapp.dto;

import lombok.Builder;

@Builder
public record GameDTO(String title,
                      String platform,
                      String developer,
                      Integer totalAchievements,
                      Integer unlockedCount,
                      Double completionPercent) {
}
