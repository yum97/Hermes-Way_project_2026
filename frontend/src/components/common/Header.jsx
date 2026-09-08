/**
 * HERMES WAYの共通ヘッダー
 *
 * ロゴ、ナビゲーション、
 * 言語変更ボタン、ログインボタンを表示する。
 */
function Header() {

  /**
   * 言語変更処理
   *
   * 現在は画面だけ作成する。
   * 日本語・韓国語の切り替え機能は後で実装する。
   */
  const handleLanguageChange = () => {
    alert("言語変更機能は後で実装します。");
  };

  /**
   * ログイン処理
   *
   * 現在はログインページがまだないため、
   * 仮のメッセージを表示する。
   */
  const handleLogin = () => {
    alert("ログインページは後で実装します。");
  };

  return (
    <header className="site-header">

      <div className="header-container">

        {/* =================================
            ロゴ
        ================================= */}
        <div className="logo">

          <span className="logo-mark">
            HmW
          </span>

          <span className="logo-name">
            HERMES WAY
          </span>

        </div>


        {/* =================================
            メインナビゲーション
        ================================= */}
        <nav className="main-nav">

          <a href="#travel">
            Travel
          </a>

          <a href="#places">
            Places
          </a>

          <a href="#community">
            Community
          </a>

        </nav>


        {/* =================================
            ヘッダー右側のボタン
        ================================= */}
        <div className="header-actions">

          {/* 言語変更ボタン */}
          <button
            type="button"
            className="language-button"
            onClick={handleLanguageChange}
          >
            🌐 日本語
          </button>

          {/* ログインボタン */}
          <button
            type="button"
            className="login-button small"
            onClick={handleLogin}
          >
            Login
          </button>

        </div>

      </div>

    </header>
  );
}

export default Header;