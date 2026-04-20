import { Link } from 'react-router-dom';

export default function HomePage() {
  return (
    <div>
      <h1>🏆 AchievementVault</h1>
      <p>Gaming hub za praćenje dostignuća i trofeeja.</p>
      <Link to="/games">Prikaži sve igre</Link>
    </div>
  );
}