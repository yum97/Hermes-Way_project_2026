/**
 * HERMES WAYの共通フッター
 *
 * サービス情報、ナビゲーション、
 * SNSリンク、著作権情報を表示する。
 */
function Footer() {

  /* =========================================
     SNSリンク

     現在は仮のURLを使用する。
     実際の公式アカウントを作成した後に変更する。
  ========================================== */
  const socialLinks = {
    instagram: "https://www.instagram.com/",
    x: "https://x.com/",
    youtube: "https://www.youtube.com/",
  };


  return (
    <footer className="site-footer">

      <div className="footer-container">

        {/* =================================
            サービス情報
        ================================== */}
        <div className="footer-brand">

          <div className="footer-logo">
            HmW
          </div>

          <h3>
            HERMES WAY
          </h3>

          <p>
            Find Your Way, Share Your Journey.
          </p>

        </div>


        {/* =================================
            フッターナビゲーション
        ================================== */}
        <div className="footer-links">

          <h4>
            HERMES WAY
          </h4>

          <a href="#travel">
            Travel
          </a>

          <a href="#places">
            Places
          </a>

          <a href="#community">
            Community
          </a>

        </div>


        {/* =================================
            SNS
        ================================== */}
        <div className="footer-social">

          <h4>
            Follow Us
          </h4>

          <div className="social-icons">

            {/* Instagram */}
            <a
              href={socialLinks.instagram}
              target="_blank"
              rel="noopener noreferrer"
              aria-label="Instagram"
            >
              ◎
            </a>

            {/* X */}
            <a
              href={socialLinks.x}
              target="_blank"
              rel="noopener noreferrer"
              aria-label="X"
            >
              𝕏
            </a>

            {/* YouTube */}
            <a
              href={socialLinks.youtube}
              target="_blank"
              rel="noopener noreferrer"
              aria-label="YouTube"
            >
              ▶
            </a>

          </div>

        </div>

      </div>


      {/* =================================
          Copyright
      ================================== */}
      <div className="footer-bottom">

        <p>
          © 2026 HERMES WAY. All Rights Reserved.
        </p>

      </div>

    </footer>
  );
}

export default Footer;