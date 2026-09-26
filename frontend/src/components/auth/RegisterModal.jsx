import { useState } from "react";

// 新規会員登録用モーダル
function RegisterModal({ onClose, onLoginClick }) {
  // 入力フォーム
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [nickname, setNickname] = useState("");
  const [name, setName] = useState("");

  // エラーメッセージ
  const [errorMessage, setErrorMessage] = useState("");

  // 登録処理中かどうか
  const [isLoading, setIsLoading] = useState(false);

  /**
   * 会員登録処理
   */
  const handleSubmit = async (event) => {
    event.preventDefault();

    setErrorMessage("");
    setIsLoading(true);

    try {
      const response = await fetch("/api/auth/register", {
        method: "POST",

        headers: {
          "Content-Type": "application/json",
        },

        body: JSON.stringify({
          email,
          password,
          nickname,
          name,
        }),
      });

      if (!response.ok) {
        throw new Error(
          "会員登録に失敗しました。入力内容を確認してください。"
        );
      }

      // 登録されたユーザー情報
      const user = await response.json();

      console.log("会員登録成功:", user);

      // 登録完了後ログイン画面へ移動
      onLoginClick();
    } catch (error) {
      setErrorMessage(error.message);
    } finally {
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

      {/* 新規会員登録フォーム */}
      <form
        className="login-form"
        onSubmit={handleSubmit}
      >
        {/* メールアドレス */}
        <div className="login-form-group">
          <label htmlFor="register-email">
            メールアドレス
          </label>

          <input
            id="register-email"
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
          <label htmlFor="register-password">
            パスワード
          </label>

          <input
            id="register-password"
            type="password"
            placeholder="8文字以上で入力してください"
            value={password}
            onChange={(event) =>
              setPassword(event.target.value)
            }
            minLength={8}
            required
          />
        </div>

        {/* ニックネーム */}
        <div className="login-form-group">
          <label htmlFor="register-nickname">
            ニックネーム
          </label>

          <input
            id="register-nickname"
            type="text"
            value={nickname}
            onChange={(event) =>
              setNickname(event.target.value)
            }
            required
          />
        </div>

        {/* 名前 */}
        <div className="login-form-group">
          <label htmlFor="register-name">
            名前
          </label>

          <input
            id="register-name"
            type="text"
            value={name}
            onChange={(event) =>
              setName(event.target.value)
            }
            required
          />
        </div>

        {/* エラーメッセージ */}
        {errorMessage && (
          <p className="login-error-message">
            {errorMessage}
          </p>
        )}

        {/* 会員登録ボタン */}
        <button
          type="submit"
          className="login-submit-button"
          disabled={isLoading}
        >
          {isLoading
            ? "登録中..."
            : "新規登録"}
        </button>
      </form>

      {/* ログイン画面へ戻る */}
      <div className="login-register">
        <p>
          すでにアカウントをお持ちの方
        </p>

        <button
          type="button"
          className="register-button"
          onClick={onLoginClick}
        >
          ログイン
        </button>
      </div>
    </div>
  </div>
)}

export default RegisterModal;