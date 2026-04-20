import { Routes, Route } from 'react-router-dom';
import HomePage from './pages/HomePage';
import GameListPage from './pages/GameListPage';
import GameDetailPage from './pages/GameDetailPage';
import GameEditPage from './pages/GameEditPage';

function App() {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/games" element={<GameListPage />} />
      <Route path="/details/:id" element={<GameDetailPage />} />
      <Route path="/edit/:id" element={<GameEditPage />} />
    </Routes>
  );
}

export default App;