import {
  createContext,
  useContext,
  useEffect,
  useState,
} from "react";

// 認証情報を管理するContext
const AuthContext = createContext(null);

export function AuthProvider({ children }) {
  // 現在ログインしているユーザー
  const [user, setUser] = useState(null);

  // ログイン状態確認中かどうか
  const [isAuthLoading, setIsAuthLoading] = useState(true);

  /**
   * 現在ログインしているユーザー情報を取得
   */
  const refreshUser = async () => {
    try {
      const response = await fetch("/api/auth/me", {
        method: "GET",
        credentials: "include",
      });

      // 未ログインの場合
      if (!response.ok) {
        setUser(null);
        return;
      }

      const data = await response.json();

      setUser(data);
    } catch (error) {
      console.error("ユーザー情報取得失敗:", error);
      setUser(null);
    } finally {
      setIsAuthLoading(false);
    }
  };

  /**
   * ログアウト
   */
  const logout = async () => {
    try {
      await fetch("/api/auth/logout", {
        method: "POST",
        credentials: "include",
      });
    } catch (error) {
      console.error("ログアウト失敗:", error);
    } finally {
      setUser(null);
    }
  };

  // ページ読み込み時にログイン状態を確認
  useEffect(() => {
    refreshUser();
  }, []);

  return (
    <AuthContext.Provider
      value={{
        user,
        isAuthLoading,
        refreshUser,
        logout,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
}

// AuthContextを使用するためのHook
export function useAuth() {
  return useContext(AuthContext);
}