import axios from 'axios';

const API_URL = 'http://localhost:8080/api/games';

export interface Game {
  id?: number;
  title: string;
  platform: string;
  developer: string;
  releaseYear: number;
  totalAchievements: number;
  unlockedCount?: number;
  completionPercent?: number;
}

export const getAllGames = async (): Promise<Game[]> => {
  const response = await axios.get<Game[]>(API_URL);
  return response.data;
};

export const getGame = async (id: number): Promise<Game> => {
  const response = await axios.get<Game>(`${API_URL}/${id}`);
  return response.data;
};

export const createGame = async (game: Game): Promise<Game> => {
  const response = await axios.post<Game>(API_URL, game);
  return response.data;
};

export const deleteGame = async (title: string): Promise<void> => {
  await axios.delete(`${API_URL}/${title}`);
};

export const updateGame = async (id: number, game: Game): Promise<Game> => {
  const response = await axios.put<Game>(`${API_URL}/${id}`, game);
  return response.data;
};