import { useState } from "react";

import Header from "./components/common/Header";
import Footer from "./components/common/Footer";
import LoginModal from "./components/auth/LoginModal";
import RegisterModal from "./components/auth/RegisterModal";
import Home from "./pages/Home";

// Reactアプリケーション全体の画面構成
function App() {
  // ログインモーダルの表示状態
  const [isLoginModalOpen, setIsLoginModalOpen] = useState(false);

  // 新規登録モーダルの表示状態
  const [isRegisterModalOpen, setIsRegisterModalOpen] = useState(false);

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
      <Header onLoginClick={openLoginModal} />

      <Home />

      <Footer />

      {/* ログインモーダル */}
      {isLoginModalOpen && (
        <LoginModal
          onClose={() => setIsLoginModalOpen(false)}
          onRegisterClick={openRegisterModal}
        />
      )}

      {/* 新規登録モーダル */}
      {isRegisterModalOpen && (
        <RegisterModal
          onClose={() => setIsRegisterModalOpen(false)}
          onLoginClick={openLoginModal}
        />
      )}
    </>
  );
}

export default App;