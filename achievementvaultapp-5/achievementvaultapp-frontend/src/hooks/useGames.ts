import { useState, useEffect } from 'react';
import type { Game } from '../types/Game';
import { mockGames } from '../mockGameData';

interface UseGamesResult {
  data: Game[];
  loading: boolean;
  error: string | null;
}

const useGames = (): UseGamesResult => {
  const [data, setData] = useState<Game[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const timer = setTimeout(() => {
      try {
        setData(mockGames);
        setLoading(false);
      } catch (e) {
        setError('Greška pri dohvatu podataka');
        setLoading(false);
      }
    }, 1000);

    return () => clearTimeout(timer);
  }, []);

  return { data, loading, error };
};

export default useGames;