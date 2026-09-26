import { useAuth } from "../../context/AuthContext";

// ログインユーザーのマイページ
function MyPage() {
  // 現在ログインしているユーザー
  const { user } = useAuth();

  // ユーザー情報がない場合
  if (!user) {
    return null;
  }

  return (
    <main className="mypage">
      <section className="mypage-card">
        {/* プロフィール上部 */}
        <div className="mypage-header">
          {/* プロフィール画像 */}
          <div className="mypage-avatar">
            {user.profileImage ? (
              <img
                src={user.profileImage}
                alt={`${user.nickname}のプロフィール`}
              />
            ) : (
              <span>
                {user.nickname?.charAt(0)}
              </span>
            )}
          </div>

          {/* ユーザー基本情報 */}
          <div className="mypage-user-info">
            <h1>{user.nickname}</h1>

            <p>{user.email}</p>
          </div>
        </div>

        {/* ユーザー詳細情報 */}
        <div className="mypage-info">
          <div className="mypage-info-item">
            <strong>名前</strong>

            <p>{user.name}</p>
          </div>

          <div className="mypage-info-item">
            <strong>ニックネーム</strong>

            <p>{user.nickname}</p>
          </div>

          <div className="mypage-info-item">
            <strong>自己紹介</strong>

            <p>
              {user.bio ||
                "自己紹介はまだ登録されていません。"}
            </p>
          </div>

          <div className="mypage-info-item">
            <strong>住所</strong>

            <p>
              {user.address ||
                "住所はまだ登録されていません。"}
            </p>
          </div>
        </div>

        {/* 今後ここに追加予定 */}
        <div className="mypage-menu">
          <button type="button">
            プロフィール編集
          </button>

          <button type="button">
            投稿一覧
          </button>

          <button type="button">
            いいねした投稿
          </button>

          <button type="button">
            保存した投稿
          </button>
        </div>
      </section>
    </main>
  );
}

export default MyPage;