import { useState } from "react";

import Header from "./components/common/Header";
import Footer from "./components/common/Footer";
import LoginModal from "./components/auth/LoginModal";
import Home from "./pages/Home";

// Reactアプリケーション全体の画面構成
function App() {
  // ログインモーダルの表示状態
  const [isLoginModalOpen, setIsLoginModalOpen] = useState(false);

  return (
    <>
      <Header
        onLoginClick={() => setIsLoginModalOpen(true)}
      />

      <Home />

      <Footer />

      {/* ログインモーダル */}
      {isLoginModalOpen && (
        <LoginModal
          onClose={() => setIsLoginModalOpen(false)}
        />
      )}
    </>
  );
}

export default App;