import type { Achievement } from '../types/Achievement';

interface AchievementListProps {
  achievements: Achievement[];
  loading: boolean;
}

const AchievementListComponent = ({ achievements, loading }: AchievementListProps) => {
  if (loading) {
    return <p style={{ color: '#888' }}>⏳ Učitavanje dostignuća...</p>;
  }

  if (achievements.length === 0) {
    return <p style={{ color: '#888' }}>Nema dostignuća za ovu igru.</p>;
  }

  return (
    <div style={{ marginTop: '16px' }}>
      <h3>🏅 Dostignuća</h3>
      <ul style={{ listStyle: 'none', padding: 0, marginTop: '12px' }}>
        {achievements.map((achievement) => (
          <li
            key={achievement.id}
            style={{
              padding: '12px 16px',
              marginBottom: '8px',
              border: '1px solid #ddd',
              borderRadius: '8px',
              backgroundColor: achievement.isSecret ? '#fff8e1' : '#f9f9f9',
            }}
          >
            <div style={{ display: 'flex', justifyContent: 'space-between' }}>
              <strong>{achievement.isSecret ? '🔒 ' : '🏆 '}{achievement.name}</strong>
              <span style={{ color: '#e6a817', fontWeight: 'bold' }}>{achievement.points} pts</span>
            </div>
            <p style={{ margin: '4px 0 0', color: '#666', fontSize: '13px' }}>{achievement.description}</p>
            <span style={{
              fontSize: '11px',
              marginTop: '6px',
              display: 'inline-block',
              padding: '2px 8px',
              borderRadius: '12px',
              backgroundColor: '#e0f0ff',
              color: '#0077cc',
            }}>
              {achievement.category}
            </span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default AchievementListComponent;