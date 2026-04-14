import { useState } from 'react';
import useGames from './hooks/useGames';
import useAchievements from './hooks/useAchievements';
import GameListComponent from './components/GameListComponent';
import GameDetailComponent from './components/GameDetailComponent';
import AchievementListComponent from './components/AchievementListComponent';

function App() {
  const { data, loading, error } = useGames();
  const [selectedGameTitle, setSelectedGameTitle] = useState<string | null>(null);
  const { data: achievements, loading: achievementsLoading } = useAchievements(selectedGameTitle);

  if (loading) {
    return <p style={{ padding: '40px', fontSize: '18px' }}>⏳ Učitavanje igara...</p>;
  }

  if (error) {
    return <p style={{ padding: '40px', color: 'red' }}>❌ {error}</p>;
  }

  return (
    <div style={{ maxWidth: '800px', margin: '40px auto', padding: '0 20px', fontFamily: 'sans-serif' }}>
      <h1>🏆 AchievementVault</h1>
      <p style={{ color: '#666', marginBottom: '24px' }}>Gaming Hub — Praćenje dostignuća i trofeeja</p>

      <GameListComponent
        games={data}
        onSelectGame={setSelectedGameTitle}
        selectedGameTitle={selectedGameTitle}
      />

      <GameDetailComponent
        selectedGameTitle={selectedGameTitle}
        games={data}
      />

      <AchievementListComponent
        achievements={achievements}
        loading={achievementsLoading}
      />
    </div>
  );
}

export default App;