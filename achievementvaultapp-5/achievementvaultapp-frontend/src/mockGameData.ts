import type { Game } from './types/Game';

export const mockGames: Game[] = [
  {
    title: 'The Witcher 3: Wild Hunt',
    platform: 'PC',
    developer: 'CD Projekt Red',
    totalAchievements: 78,
    unlockedCount: 52,
    completionPercent: 66.67,
  },
  {
    title: 'Hades',
    platform: 'PC',
    developer: 'Supergiant Games',
    totalAchievements: 49,
    unlockedCount: 49,
    completionPercent: 100,
  },
  {
    title: 'Elden Ring',
    platform: 'PlayStation 5',
    developer: 'FromSoftware',
    totalAchievements: 42,
    unlockedCount: 10,
    completionPercent: 23.81,
  },
];