export interface Game {
  id?: number;
  title: string;
  platform: string;
  developer: string;
  totalAchievements: number;
  unlockedCount: number;
  completionPercent: number;
}