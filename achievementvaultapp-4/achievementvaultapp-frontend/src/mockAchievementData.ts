import type { Achievement } from './types/Achievement';

export const mockAchievements: Achievement[] = [
  {
    id: 1,
    gameName: 'The Witcher 3: Wild Hunt',
    name: 'Gwent Master',
    description: 'Defeat Gwent players in every region.',
    points: 30,
    isSecret: false,
    category: 'Gameplay',
  },
  {
    id: 2,
    gameName: 'The Witcher 3: Wild Hunt',
    name: 'Passed the Trial',
    description: 'Complete the main story.',
    points: 50,
    isSecret: false,
    category: 'Story',
  },
  /*{
    id: 3,
    gameName: 'Hades',
    name: 'Escaped for the First Time',
    description: 'Complete your first successful escape from the Underworld.',
    points: 40,
    isSecret: false,
    category: 'Story',
  },*/
  {
    id: 4,
    gameName: 'Elden Ring',
    name: 'Elden Lord',
    description: 'Reach the top ending. Secret achievement.',
    points: 90,
    isSecret: true,
    category: 'Story',
  },
  {
    id: 5,
    gameName: 'Elden Ring',
    name: 'Shardbearer Godrick',
    description: 'Defeat Godrick the Grafted.',
    points: 25,
    isSecret: false,
    category: 'Combat',
  },
];