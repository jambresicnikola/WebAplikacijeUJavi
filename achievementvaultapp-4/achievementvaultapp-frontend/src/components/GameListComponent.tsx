import type { Game } from '../types/Game';

interface GameListProps {
  games: Game[];
  onSelectGame: (title: string) => void;
  selectedGameTitle: string | null;
}

const GameListComponent = ({ games, onSelectGame, selectedGameTitle }: GameListProps) => {
  return (
    <div>
      <h2>🎮 Lista igara</h2>
      <ul style={{ listStyle: 'none', padding: 0 }}>
        {games.map((game) => (
          <li
            key={game.title}
            onClick={() => onSelectGame(game.title)}
            style={{
              padding: '12px 16px',
              marginBottom: '8px',
              border: selectedGameTitle === game.title ? '2px solid #61dafb' : '1px solid #ccc',
              borderRadius: '8px',
              cursor: 'pointer',
              backgroundColor: selectedGameTitle === game.title ? '#e8f7ff' : '#f9f9f9',
            }}
          >
            <strong>{game.title}</strong>
            <span style={{ marginLeft: '12px', color: '#666' }}>
              {game.platform} — {game.developer}
            </span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default GameListComponent;