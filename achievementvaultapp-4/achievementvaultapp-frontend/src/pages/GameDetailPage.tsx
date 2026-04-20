import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getGame } from '../api/gameApi';
import type { Game } from '../api/gameApi';

export default function GameDetailPage() {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [game, setGame] = useState<Game | null>(null);

  useEffect(() => {
    if (id) {
      getGame(Number(id)).then(setGame);
    }
  }, [id]);

  if (!game) return <p>Učitavanje...</p>;

  return (
    <div>
      <h2>🏆 {game.title}</h2>
      <p><strong>Platforma:</strong> {game.platform}</p>
      <p><strong>Developer:</strong> {game.developer}</p>
      <p><strong>Godina izdanja:</strong> {game.releaseYear}</p>
      <p><strong>Ukupno achievementa:</strong> {game.totalAchievements}</p>
      <button onClick={() => navigate('/games')} style={{ marginTop: '16px' }}>
        ← Natrag na listu
      </button>
    </div>
  );
}