import { Link } from "react-router-dom";
import { useAuth } from "../../context/AuthContext";

// サイト上部のヘッダーコンポーネント
function Header({ onLoginClick }) {
  // 現在のログインユーザーと認証状態
  const {
    user,
    isAuthLoading,
    logout,
  } = useAuth();

  return (
    <header className="header">
      {/* 左側のブランドロゴ */}
      <Link to="/" className="brand">
        <span className="brand-mark">
          HmW
        </span>

        <span className="brand-name">
          HERMES WAY
        </span>
      </Link>

      {/* メインナビゲーション */}
      <nav className="nav">
        <a href="#travel">
          Travel
        </a>

        <a href="#places">
          Places
        </a>

        <a href="#community">
          Community
        </a>

        <a href="#search">
          Search
        </a>
      </nav>

      {/* 右側の操作メニュー */}
      <div className="header-actions">
        {/* 言語切り替え */}
        <button
          type="button"
          className="language-button"
        >
          JP / KR
        </button>

        {/* 認証状態の確認完了後に表示 */}
        {!isAuthLoading && (
          <>
            {user ? (
              <>
                {/* ログイン中のユーザー */}
                <Link
                  to="/profile/me"
                  className="profile-link"
                >
                  {user.nickname}
                </Link>

                {/* ログアウト */}
                <button
                  type="button"
                  className="login-button"
                  onClick={logout}
                >
                  Logout
                </button>
              </>
            ) : (
              /* 未ログイン */
              <button
                type="button"
                className="login-button"
                onClick={onLoginClick}
              >
                Login
              </button>
            )}
          </>
        )}
      </div>
    </header>
  );
}

export default Header;