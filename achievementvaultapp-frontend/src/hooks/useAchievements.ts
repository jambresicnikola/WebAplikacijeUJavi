import { useState, useEffect } from 'react';
import type { Achievement } from '../types/Achievement';
import { mockAchievements } from '../mockAchievementData';

interface UseAchievementsResult {
  data: Achievement[];
  loading: boolean;
  error: string | null;
}

const useAchievements = (gameName: string | null): UseAchievementsResult => {
  const [data, setData] = useState<Achievement[]>([]);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    if (!gameName) {
      setData([]);
      return;
    }

    setLoading(true);

    const timer = setTimeout(() => {
      try {
        const filtered = mockAchievements.filter((a) => a.gameName === gameName);
        setData(filtered);
        setLoading(false);
      } catch (e) {
        setError('Greška pri dohvatu dostignuća');
        setLoading(false);
      }
    }, 800);

    return () => clearTimeout(timer);
  }, [gameName]);

  return { data, loading, error };
};

export default useAchievements;