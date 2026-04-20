import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getGame, updateGame, type Game } from '../api/gameApi';

export default function GameEditPage() {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [form, setForm] = useState<Game>({
    title: '',
    platform: '',
    developer: '',
    releaseYear: new Date().getFullYear(),
    totalAchievements: 0,
  });

  useEffect(() => {
    if (id) {
      getGame(Number(id)).then(setForm);
    }
  }, [id]);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await updateGame(Number(id), {
        ...form,
        releaseYear: Number(form.releaseYear),
        totalAchievements: Number(form.totalAchievements),
      });
      navigate('/games');
    } catch (err) {
      alert('Greška pri ažuriranju igre.');
    }
  };

  return (
    <div>
      <h2>✏️ Uredi igru</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <input name="title" value={form.title} onChange={handleChange} placeholder="Naslov" required />
        </div>
        <div>
          <input name="platform" value={form.platform} onChange={handleChange} placeholder="Platforma" required />
        </div>
        <div>
          <input name="developer" value={form.developer} onChange={handleChange} placeholder="Developer" required />
        </div>
        <div>
          <input name="releaseYear" type="number" value={form.releaseYear} onChange={handleChange} placeholder="Godina izdanja" required />
        </div>
        <div>
          <input name="totalAchievements" type="number" value={form.totalAchievements} onChange={handleChange} placeholder="Broj achievementa" required />
        </div>
        <button type="submit" style={{ marginTop: '8px' }}>Spremi izmjene</button>
        <button type="button" onClick={() => navigate('/games')} style={{ marginLeft: '8px' }}>Odustani</button>
      </form>
    </div>
  );
}