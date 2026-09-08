/**
 * HERMES WAYのホーム画面
 *
 * メインビジュアル、
 * 旅行先検索、
 * 人気旅行先、
 * 人気旅行投稿、
 * 最新旅行投稿を表示する。
 */
function Home() {

  /* =========================================
     人気旅行先の仮データ
     
     現在はバックエンドと接続していないため、
     サンプルデータを使用する。

     後でSpring Boot APIから取得する。
  ========================================== */
  const popularPlaces = [
    {
      id: 1,
      name: "東京",
      description: "伝統と現代が融合する日本の大都市",
      image:
        "https://images.unsplash.com/photo-1540959733332-eab4deabeeaf",
    },
    {
      id: 2,
      name: "京都",
      description: "日本の歴史と文化を感じられる街",
      image:
        "https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e",
    },
    {
      id: 3,
      name: "大阪",
      description: "グルメと活気あふれる関西の街",
      image:
        "https://images.unsplash.com/photo-1590559899731-a382839e5549",
    },
    {
      id: 4,
      name: "北海道",
      description: "美しい自然と豊かな食文化",
      image:
        "https://images.unsplash.com/photo-1578637387939-43c525550085",
    },
  ];


  /* =========================================
     人気旅行投稿の仮データ
  ========================================== */
  const popularPosts = [
    {
      id: 1,
      title: "東京で絶対に行きたい観光スポット",
      author: "Traveler",
      likes: 128,
    },
    {
      id: 2,
      title: "京都で過ごした3日間",
      author: "Japan Lover",
      likes: 96,
    },
    {
      id: 3,
      title: "大阪グルメを食べ歩いてみた",
      author: "Food Traveler",
      likes: 82,
    },
  ];


  /* =========================================
     最新旅行投稿の仮データ
  ========================================== */
  const latestPosts = [
    {
      id: 1,
      title: "箱根でゆっくり温泉旅行",
      author: "HMW User",
    },
    {
      id: 2,
      title: "鎌倉の日帰り旅行",
      author: "Travel Note",
    },
    {
      id: 3,
      title: "北海道で見つけた絶景",
      author: "Wanderer",
    },
  ];


  /* =========================================
     旅行先検索機能

     現在は検索APIがないため、
     入力された文字を確認するだけ。

     後でSpring Bootの検索APIと接続する。
  ========================================== */
  const handleSearch = (event) => {

    // form送信によるページリロードを防止
    event.preventDefault();

    // inputのname="search"から入力値を取得
    const keyword = event.target.elements.search.value;

    // 空欄の場合
    if (!keyword.trim()) {
      alert("旅行先を入力してください。");
      return;
    }

    // 現在は仮の処理
    alert(`「${keyword}」を検索します。`);
  };


  /* =========================================
     メインエリアのログインボタン
  ========================================== */
  const handleMainLogin = () => {
    alert("ログインページは後で実装します。");
  };


  return (
    <div className="home">

      {/* =====================================
          Hero Section
          
          HERMES WAYの最初のメインビジュアル
      ====================================== */}
      <section
        id="travel"
        className="hero"
      >

        <div className="hero-container">

          {/* ---------------------------------
              Hero 左側
          ---------------------------------- */}
          <div className="hero-content">

            {/* キャッチコピー */}
            <p className="hero-subtitle">
              Find Your Way, Share Your Journey.
            </p>

            {/* メインタイトル */}
            <h1>
              あなたの旅を、
              <br />
              もっと自由に。
            </h1>

            {/* サービス説明 */}
            <p className="hero-description">
              HERMES WAYで旅先を見つけ、
              <br />
              あなたの旅の思い出をシェアしよう。
            </p>


            {/* ---------------------------------
                旅行先検索フォーム
            ---------------------------------- */}
            <form
              className="search-form"
              onSubmit={handleSearch}
            >

              <input
                type="text"
                name="search"
                placeholder="旅行先、場所、キーワードを検索..."
              />

              <button type="submit">
                Search
              </button>

            </form>

          </div>


          {/* ---------------------------------
              Hero 右側
              
              사용자가 요청한 메인 로그인 버튼
          ---------------------------------- */}
          <div className="hero-login">

            <p>
              旅の情報を見つけて、
              <br />
              あなたの旅をシェアしよう。
            </p>

            <button
              type="button"
              className="login-button"
              onClick={handleMainLogin}
            >
              Login / Register
            </button>

          </div>

        </div>

      </section>


      {/* =====================================
          人気旅行先
      ====================================== */}
      <section
        id="places"
        className="content-section"
      >

        <div className="section-header">

          <div>

            <p className="section-label">
              DESTINATIONS
            </p>

            <h2>
              人気の旅行先
            </h2>

          </div>

          <a href="#all-places">
            すべて見る →
          </a>

        </div>


        {/* 人気旅行地カードリスト */}
        <div className="place-grid">

          {popularPlaces.map((place) => (

            <article
              className="place-card"
              key={place.id}
            >

              {/* 旅行地画像 */}
              <img
                src={`${place.image}?auto=format&fit=crop&w=800&q=80`}
                alt={place.name}
              />

              {/* 旅行地情報 */}
              <div className="place-card-content">

                <h3>
                  {place.name}
                </h3>

                <p>
                  {place.description}
                </p>

                <button type="button">
                  Explore →
                </button>

              </div>

            </article>

          ))}

        </div>

      </section>


      {/* =====================================
          人気旅行投稿
      ====================================== */}
      <section
        id="community"
        className="content-section"
      >

        <div className="section-header">

          <div>

            <p className="section-label">
              COMMUNITY
            </p>

            <h2>
              人気旅行投稿
            </h2>

          </div>

          <a href="#all-posts">
            すべて見る →
          </a>

        </div>


        {/* 人気旅行投稿カード */}
        <div className="post-grid">

          {popularPosts.map((post) => (

            <article
              className="post-card"
              key={post.id}
            >

              {/* 投稿画像の仮表示 */}
              <div className="post-card-image">
                Travel Story
              </div>

              <div className="post-card-content">

                <h3>
                  {post.title}
                </h3>

                <p>
                  by {post.author}
                </p>

                <span>
                  ♥ {post.likes}
                </span>

              </div>

            </article>

          ))}

        </div>

      </section>


      {/* =====================================
          最新旅行投稿
      ====================================== */}
      <section className="content-section">

        <div className="section-header">

          <div>

            <p className="section-label">
              LATEST
            </p>

            <h2>
              最新旅行投稿
            </h2>

          </div>

          <a href="#latest">
            すべて見る →
          </a>

        </div>


        {/* 最新旅行投稿リスト */}
        <div className="latest-post-list">

          {latestPosts.map((post) => (

            <article
              className="latest-post"
              key={post.id}
            >

              {/* 投稿サムネイル */}
              <div className="latest-post-thumbnail">
                HmW
              </div>

              {/* 投稿情報 */}
              <div className="latest-post-content">

                <h3>
                  {post.title}
                </h3>

                <p>
                  {post.author}
                </p>

              </div>

              {/* 移動矢印 */}
              <span className="arrow">
                →
              </span>

            </article>

          ))}

        </div>

      </section>

    </div>
  );
}

export default Home;