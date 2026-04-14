import type { Game } from '../types/Game';

interface GameDetailProps {
  selectedGameTitle: string | null;
  games: Game[];
}

const GameDetailComponent = ({ selectedGameTitle, games }: GameDetailProps) => {
  if (!selectedGameTitle) {
    return <p style={{ color: '#888', marginTop: '16px' }}>👆 Klikni na igru za prikaz detalja.</p>;
  }

  const game = games.find((g) => g.title === selectedGameTitle);

  if (!game) {
    return <p style={{ color: 'red' }}>Igra nije pronađena.</p>;
  }

  return (
    <div
      style={{
        marginTop: '24px',
        padding: '20px',
        border: '1px solid #61dafb',
        borderRadius: '12px',
        backgroundColor: '#f0fbff',
      }}
    >
      <h2>🏆 {game.title}</h2>
      <table style={{ marginTop: '12px', borderCollapse: 'collapse', width: '100%' }}>
        <tbody>
          <tr>
            <td style={tdStyle}><strong>Platforma</strong></td>
            <td style={tdStyle}>{game.platform}</td>
          </tr>
          <tr>
            <td style={tdStyle}><strong>Developer</strong></td>
            <td style={tdStyle}>{game.developer}</td>
          </tr>
          <tr>
            <td style={tdStyle}><strong>Ukupno dostignuća</strong></td>
            <td style={tdStyle}>{game.totalAchievements}</td>
          </tr>
          <tr>
            <td style={tdStyle}><strong>Otključano</strong></td>
            <td style={tdStyle}>{game.unlockedCount}</td>
          </tr>
          <tr>
            <td style={tdStyle}><strong>Završenost</strong></td>
            <td style={tdStyle}>{game.completionPercent.toFixed(2)}%</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

const tdStyle: React.CSSProperties = {
  padding: '8px 12px',
  borderBottom: '1px solid #ddd',
};

export default GameDetailComponent;