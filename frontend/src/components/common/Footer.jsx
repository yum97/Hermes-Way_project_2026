// サイト下部のフッターコンポーネント
function Footer() {
  return (
    <footer className="footer">
      <div className="footer-main">
        {/* ブランド情報 */}
        <div className="footer-brand">
          <div className="footer-logo">
            <span>HmW</span>
            <strong>HERMES WAY</strong>
          </div>

          <p>
            Find Your Way,
            <br />
            Share Your Journey.
          </p>
        </div>

        {/* フッターナビゲーション */}
        <div className="footer-column">
          <h3>Explore</h3>
          <a href="#">Travel</a>
          <a href="#">Places</a>
          <a href="#">Community</a>
          <a href="#">Search</a>
        </div>

        <div className="footer-column">
          <h3>HERMES WAY</h3>
          <a href="#">About Us</a>
          <a href="#">Contact</a>
          <a href="#">Terms</a>
          <a href="#">Privacy</a>
        </div>

        {/* SNS */}
        <div className="footer-column">
          <h3>Follow Us</h3>

          <a href="#">Instagram</a>
          <a href="#">X</a>
          <a href="#">YouTube</a>
        </div>
      </div>

      <div className="footer-bottom">
        <p>
          © 2026 HERMES WAY. All rights reserved.
        </p>
      </div>
    </footer>
  );
}

export default Footer;