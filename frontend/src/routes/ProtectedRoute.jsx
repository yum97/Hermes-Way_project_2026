import { Navigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext";

// ログイン済みユーザーのみアクセス可能なRoute
function ProtectedRoute({ children }) {
  const {
    user,
    isAuthLoading,
  } = useAuth();

  // ログイン状態を確認中
  if (isAuthLoading) {
    return (
      <main className="page-loading">
        読み込み中...
      </main>
    );
  }

  // 未ログインの場合はトップページへ戻す
  if (!user) {
    return <Navigate to="/" replace />;
  }

  // ログイン済みの場合はページを表示
  return children;
}

export default ProtectedRoute;