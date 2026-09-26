import { useState } from "react";
import { Route, Routes } from "react-router-dom";

import Header from "./components/common/Header";
import Footer from "./components/common/Footer";

import LoginModal from "./components/auth/LoginModal";
import RegisterModal from "./components/auth/RegisterModal";

import Home from "./pages/Home";
import MyPage from "./pages/profile/MyPage";

import ProtectedRoute from "./routes/ProtectedRoute";

// Reactアプリケーション全体の画面構成
function App() {
  // ログインモーダルの表示状態
  const [isLoginModalOpen, setIsLoginModalOpen] =
    useState(false);

  // 新規登録モーダルの表示状態
  const [isRegisterModalOpen, setIsRegisterModalOpen] =
    useState(false);

  /**
   * ログインモーダルを開く
   */
  const openLoginModal = () => {
    setIsRegisterModalOpen(false);
    setIsLoginModalOpen(true);
  };

  /**
   * 新規登録モーダルを開く
   */
  const openRegisterModal = () => {
    setIsLoginModalOpen(false);
    setIsRegisterModalOpen(true);
  };

  return (
    <>
      {/* 共通ヘッダー */}
      <Header
        onLoginClick={openLoginModal}
      />

      {/* ページルーティング */}
      <Routes>
        {/* トップページ */}
        <Route
          path="/"
          element={<Home />}
        />

        {/* ログインユーザー専用プロフィール */}
        <Route
          path="/profile/me"
          element={
            <ProtectedRoute>
              <MyPage />
            </ProtectedRoute>
          }
        />
      </Routes>

      {/* 共通フッター */}
      <Footer />

      {/* ログインモーダル */}
      {isLoginModalOpen && (
        <LoginModal
          onClose={() =>
            setIsLoginModalOpen(false)
          }
          onRegisterClick={
            openRegisterModal
          }
        />
      )}

      {/* 新規登録モーダル */}
      {isRegisterModalOpen && (
        <RegisterModal
          onClose={() =>
            setIsRegisterModalOpen(false)
          }
          onLoginClick={
            openLoginModal
          }
        />
      )}
    </>
  );
}

export default App;