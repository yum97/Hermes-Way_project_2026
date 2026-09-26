import { useAuth } from "../../context/AuthContext";
import { useState } from "react";

// ログイン用モーダルコンポーネント
function LoginModal({ onClose, onRegisterClick }) {

  // AuthContextからrefreshUser関数を取得
  const { refreshUser } = useAuth();

  // メールアドレス
  const [email, setEmail] = useState("");

  // パスワード
  const [password, setPassword] = useState("");

  // エラーメッセージ
  const [errorMessage, setErrorMessage] = useState("");

  // ログイン処理中かどうか
  const [isLoading, setIsLoading] = useState(false);

  // ログインフォーム送信時の処理
  const handleSubmit = async (event) => {
    event.preventDefault();

    // 前回のエラーを初期化
    setErrorMessage("");

    // ログイン処理開始
    setIsLoading(true);

    try {

      // Spring BootのログインAPIを呼び出す
      const response = await fetch("/api/auth/login", {
        method: "POST",

        headers: {
          "Content-Type": "application/json",
        },

        // HttpOnly Cookieを受け取るために必要
        credentials: "include",

        body: JSON.stringify({
          email: email,
          password: password,
        }),
      });

      // ログイン失敗
      if (!response.ok) {
        throw new Error(
          "メールアドレスまたはパスワードが正しくありません。"
        );
      }

      // ログイン成功後、現在のユーザー情報を取得
      await refreshUser();

      // モーダルを閉じる
      onClose();

    } catch (error) {

      // エラーメッセージを表示
      setErrorMessage(error.message);

    } finally {

      // ログイン処理終了
      setIsLoading(false);
    }
  };

  return (
    <div
      className="login-modal-overlay"
      onClick={onClose}
    >
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
          <div className="login-modal-logo">
            HmW
          </div>

          <h2>HERMES WAY</h2>

          <p>
            Find Your Way, Share Your Journey.
          </p>
        </div>

        {/* ログインフォーム */}
        <form
          className="login-form"
          onSubmit={handleSubmit}
        >

          {/* メールアドレス */}
          <div className="login-form-group">
            <label htmlFor="email">
              メールアドレス
            </label>

            <input
              id="email"
              type="email"
              placeholder="example@email.com"

              value={email}

              onChange={(event) =>
                setEmail(event.target.value)
              }

              required
            />
          </div>

          {/* パスワード */}
          <div className="login-form-group">
            <label htmlFor="password">
              パスワード
            </label>

            <input
              id="password"
              type="password"
              placeholder="パスワードを入力してください"

              value={password}

              onChange={(event) =>
                setPassword(event.target.value)
              }

              required
            />
          </div>

          {/* ログイン失敗時のメッセージ */}
          {errorMessage && (
            <p className="login-error-message">
              {errorMessage}
            </p>
          )}

          {/* ログインボタン */}
          <button
            type="submit"
            className="login-submit-button"
            disabled={isLoading}
          >
            {isLoading
              ? "ログイン中..."
              : "ログイン"}
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
          onClick={() =>
            console.log("Googleログイン")
          }
        >
          <span className="google-icon">
            G
          </span>

          Googleでログイン
        </button>

        {/* 新規登録 */}
        <div className="login-register">
          <p>
            アカウントをお持ちでない方
          </p>

          <button
            type="button"
            className="register-button"
            onClick={onRegisterClick}
          >
            新規登録
          </button>
        </div>

      </div>
    </div>
  );
}

export default LoginModal;