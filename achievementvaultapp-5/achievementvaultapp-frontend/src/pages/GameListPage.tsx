import { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { getAllGames, createGame, deleteGame } from '../api/gameApi';
import type { Game } from '../api/gameApi';

export default function GameListPage() {
  const [games, setGames] = useState<Game[]>([]);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  const [form, setForm] = useState({
    title: '',
    platform: '',
    developer: '',
    releaseYear: new Date().getFullYear(),
    totalAchievements: 0,
  });

  const fetchGames = async () => {
    try {
      const data = await getAllGames();
      setGames(data);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchGames();
  }, []);

  const handleDelete = async (title: string) => {
    if (confirm(`Obrisati igru "${title}"?`)) {
      setGames(prev => prev.filter(g => g.title !== title));
      try {
        await deleteGame(title);
      } catch (err) {
        fetchGames();
        alert('Greška pri brisanju.');
      }
    }
  };

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await createGame({
        ...form,
        releaseYear: Number(form.releaseYear),
        totalAchievements: Number(form.totalAchievements),
      });
      setForm({ title: '', platform: '', developer: '', releaseYear: new Date().getFullYear(), totalAchievements: 0 });
      fetchGames();
    } catch (err) {
      alert('Greška pri kreiranju igre (možda već postoji?).');
    }
  };

  if (loading) return <p>Učitavanje...</p>;

  return (
    <div>
      <h2>🎮 Lista igara</h2>
      <Link to="/">← Početna</Link>

      <table border={1} style={{ marginTop: '16px', width: '100%' }}>
        <thead>
          <tr>
            <th>Naslov</th>
            <th>Platforma</th>
            <th>Developer</th>
            <th>Akcije</th>
          </tr>
        </thead>
        <tbody>
          {games.map(g => (
            <tr key={g.id ?? g.title}>
              <td>{g.title}</td>
              <td>{g.platform}</td>
              <td>{g.developer}</td>
              <td>
                <button onClick={() => navigate(`/details/${g.id}`)}>
                  👁️ Detalji
                </button>
                <button onClick={() => handleDelete(g.title)} style={{ marginLeft: '8px' }}>
                  🗑️ Obriši
                </button>
                <button onClick={() => navigate(`/edit/${g.id}`)} style={{ marginLeft: '8px' }}>
                  ✏️ Uredi
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      <hr style={{ margin: '24px 0' }} />

      <h3>➕ Dodaj novu igru</h3>
      <form onSubmit={handleSubmit}>
        <div>
          <input
            name="title"
            value={form.title}
            onChange={handleChange}
            placeholder="Naslov"
            required
          />
        </div>
        <div>
          <input
            name="platform"
            value={form.platform}
            onChange={handleChange}
            placeholder="Platforma"
            required
          />
        </div>
        <div>
          <input
            name="developer"
            value={form.developer}
            onChange={handleChange}
            placeholder="Developer"
            required
          />
        </div>
        <div>
          <input
            name="releaseYear"
            type="number"
            value={form.releaseYear}
            onChange={handleChange}
            placeholder="Godina izdanja"
            required
          />
        </div>
        <button type="submit" style={{ marginTop: '8px' }}>
          Dodaj igru
        </button>
      </form>
    </div>
  );
}