// ログイン用モーダルコンポーネント
function LoginModal({ onClose }) {
  // ログインフォーム送信時の処理
  const handleSubmit = (event) => {
    event.preventDefault();

    // TODO: Spring Boot APIとのログイン処理を後で追加
    console.log("ログイン処理");
  };

  return (
    <div className="login-modal-overlay" onClick={onClose}>
      <div
        className="login-modal"
        onClick={(event) => event.stopPropagation()}
      >
        {/* モーダルを閉じるボタン */}
        <button
          type="button"
          className="login-modal-close"
          onClick={onClose}
        >
          ×
        </button>

        {/* ブランド */}
        <div className="login-modal-brand">
          <div className="login-modal-logo">HmW</div>
          <h2>HERMES WAY</h2>
          <p>Find Your Way, Share Your Journey.</p>
        </div>

        {/* ログインフォーム */}
        <form className="login-form" onSubmit={handleSubmit}>
          <div className="login-form-group">
            <label htmlFor="email">メールアドレス</label>

            <input
              id="email"
              type="email"
              placeholder="example@email.com"
              required
            />
          </div>

          <div className="login-form-group">
            <label htmlFor="password">パスワード</label>

            <input
              id="password"
              type="password"
              placeholder="パスワードを入力してください"
              required
            />
          </div>

          <button type="submit" className="login-submit-button">
            ログイン
          </button>
        </form>

        {/* 区切り線 */}
        <div className="login-divider">
          <span>または</span>
        </div>

        {/* Googleログイン */}
        <button
          type="button"
          className="google-login-button"
          onClick={() => console.log("Googleログイン")}
        >
          <span className="google-icon">G</span>
          Googleでログイン
        </button>

        {/* 新規登録 */}
        <div className="login-register">
          <p>アカウントをお持ちでない方</p>

          <button
            type="button"
            className="register-button"
            onClick={() => console.log("新規登録")}
          >
            新規登録
          </button>
        </div>
      </div>
    </div>
  );
}

export default LoginModal;