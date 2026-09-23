// サイト上部のヘッダーコンポーネント
function Header({ onLoginClick }) {
  return (
    <header className="header">
      {/* 左側のブランドロゴ */}
      <a href="/" className="brand">
        <span className="brand-mark">HmW</span>
        <span className="brand-name">HERMES WAY</span>
      </a>

      {/* メインナビゲーション */}
      <nav className="nav">
        <a href="#travel">Travel</a>
        <a href="#places">Places</a>
        <a href="#community">Community</a>
        <a href="#search">Search</a>
      </nav>

      {/* 右側の操作メニュー */}
      <div className="header-actions">
        <button className="language-button">
          JP / KR
        </button>

        <button className="login-button" onClick={onLoginClick}>
          Login
        </button>
      </div>
    </header>
  );
}

export default Header;