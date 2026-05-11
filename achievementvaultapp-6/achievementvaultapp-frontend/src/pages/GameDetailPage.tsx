import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getGame, getPlatformsByGameId } from '../api/gameApi';
import type { Game, Platform } from '../api/gameApi';

export default function GameDetailPage() {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [game, setGame] = useState<Game | null>(null);
  const [platforms, setPlatforms] = useState<Platform[]>([]);
  const [loadingPlatforms, setLoadingPlatforms] = useState(true);

  useEffect(() => {
    if (id) {
      getGame(Number(id)).then(setGame);
    }
  }, [id]);

  useEffect(() => {
    if (id) {
      getPlatformsByGameId(Number(id))
        .then(data => {
          setPlatforms(data);
          setLoadingPlatforms(false);
        })
        .catch(() => setLoadingPlatforms(false));
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

      <h3 style={{ marginTop: '24px', marginBottom: '12px' }}>🖥️ Dostupne platforme</h3>
      {loadingPlatforms ? (
        <p>Učitavanje platformi...</p>
      ) : platforms.length === 0 ? (
        <p style={{ color: '#888' }}>Nema platformi za ovu igru.</p>
      ) : (
        <table style={{ borderCollapse: 'collapse', width: '85%', margin: '40px auto', border: '1px solid #61dafb', borderRadius: '8px', overflow: 'hidden' }}>
          <thead>
            <tr style={{ backgroundColor: '#61dafb' }}>
              <th style={thStyle}>Naziv</th>
              <th style={thStyle}>Proizvođač</th>
              <th style={thStyle}>Godina izlaska</th>
            </tr>
          </thead>
          <tbody>
            {platforms.map((p, index) => (
              <tr key={p.id} style={{ backgroundColor: index % 2 === 0 ? '#f0fbff' : '#ffffff' }}>
                <td style={tdStyle}>{p.name}</td>
                <td style={tdStyle}>{p.manufacturer}</td>
                <td style={tdStyle}>{p.releaseYear}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}

      <button onClick={() => navigate('/games')} style={{ marginTop: '16px' }}>
        ← Natrag na listu
      </button>
    </div>
  );
}

const thStyle: React.CSSProperties = {
  padding: '10px 16px',
  textAlign: 'center',
  color: '#fff',
  fontWeight: 600,
  letterSpacing: '0.5px',
  borderRight: '1px solid rgba(255,255,255,0.3)',
};

const tdStyle: React.CSSProperties = {
  padding: '10px 16px',
  textAlign: 'center',
  borderBottom: '1px solid #ddd',
  borderRight: '1px solid #e0f7ff',
};