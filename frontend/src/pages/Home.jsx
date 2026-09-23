import { useState } from "react";

// 大陸データ
const continents = [
  {
    id: "asia",
    name: "Asia",
    nameJa: "アジア",
    available: true,
  },
  {
    id: "europe",
    name: "Europe",
    nameJa: "ヨーロッパ",
    available: false,
  },
  {
    id: "americas",
    name: "Americas",
    nameJa: "アメリカ",
    available: false,
  },
  {
    id: "africa",
    name: "Africa",
    nameJa: "アフリカ",
    available: false,
  },
  {
    id: "oceania",
    name: "Oceania",
    nameJa: "オセアニア",
    available: false,
  },
];

// アジアの国データ
const asianCountries = [
  {
    id: "japan",
    name: "Japan",
    nameJa: "日本",
    flag: "🇯🇵",
    available: true,
  },
  {
    id: "korea",
    name: "Korea",
    nameJa: "韓国",
    flag: "🇰🇷",
    available: false,
  },
  {
    id: "taiwan",
    name: "Taiwan",
    nameJa: "台湾",
    flag: "🇹🇼",
    available: false,
  },
  {
    id: "china",
    name: "China",
    nameJa: "中国",
    flag: "🇨🇳",
    available: false,
  },
  {
    id: "thailand",
    name: "Thailand",
    nameJa: "タイ",
    flag: "🇹🇭",
    available: false,
  },
];

// 日本の代表的な旅行先
const japanDestinations = [
  {
    name: "東京",
    english: "Tokyo",
    description: "都会の魅力と日本のカルチャーを楽しむ",
    image:
      "https://images.unsplash.com/photo-1540959733332-eab4deabeeaf?auto=format&fit=crop&w=900&q=80",
  },
  {
    name: "京都",
    english: "Kyoto",
    description: "歴史と伝統が残る日本の古都",
    image:
      "https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e?auto=format&fit=crop&w=900&q=80",
  },
  {
    name: "大阪",
    english: "Osaka",
    description: "グルメと街歩きを楽しめる都市",
    image:
      "https://images.unsplash.com/photo-1590559899731-a382839e5549?auto=format&fit=crop&w=900&q=80",
  },
  {
    name: "北海道",
    english: "Hokkaido",
    description: "雄大な自然と季節の魅力を楽しむ",
    image:
      "https://images.unsplash.com/photo-1513415277900-a62401e19be4?auto=format&fit=crop&w=900&q=80",
  },
];

// 人気投稿のサンプルデータ
const popularPosts = [
  {
    title: "東京で見つけたおすすめスポット",
    category: "観光",
    description: "実際に訪れてよかった東京のおすすめスポットを紹介します。",
    likes: 128,
    comments: 24,
  },
  {
    title: "京都で過ごす一日",
    category: "文化・歴史",
    description: "京都の街を歩きながら見つけた素敵な場所をまとめました。",
    likes: 96,
    comments: 18,
  },
  {
    title: "大阪グルメを巡る旅",
    category: "グルメ",
    description: "大阪旅行で実際に訪れたおすすめのお店を紹介します。",
    likes: 84,
    comments: 12,
  },
];

// 最新投稿のサンプルデータ
const latestPosts = [
  {
    title: "富士山を見に行ってきました",
    category: "自然",
    date: "2026.09.20",
  },
  {
    title: "銀座で見つけたお気に入りのカフェ",
    category: "カフェ",
    date: "2026.09.19",
  },
  {
    title: "北海道の夏旅行",
    category: "旅行",
    date: "2026.09.18",
  },
];

function Home() {
  // 選択中の大陸
  const [selectedContinent, setSelectedContinent] = useState("asia");

  // 選択中の国
  const [selectedCountry, setSelectedCountry] = useState("japan");

  // 検索キーワード
  const [keyword, setKeyword] = useState("");

  // 大陸を選択する処理
  const handleContinentSelect = (continent) => {
    if (!continent.available) {
      alert("現在準備中です。");
      return;
    }

    setSelectedContinent(continent.id);

    // アジアを選択した場合は日本を初期選択
    if (continent.id === "asia") {
      setSelectedCountry("japan");
    }
  };

  // 国を選択する処理
  const handleCountrySelect = (country) => {
    if (!country.available) {
      alert("現在準備中です。");
      return;
    }

    setSelectedCountry(country.id);
  };

  // 検索処理
  const handleSearch = (event) => {
    event.preventDefault();

    if (!keyword.trim()) {
      return;
    }

    alert(`検索キーワード：${keyword}`);
  };

  return (
    <main>
      {/* =========================
          Hero Section
      ========================= */}
      <section className="hero-section">
        <div className="hero-overlay"></div>

        <div className="hero-content">
          <p className="hero-label">
            HERMES WAY TRAVEL COMMUNITY
          </p>

          <h1>
            Find Your Way,
            <br />
            Share Your Journey.
          </h1>

          <p className="hero-description">
            新しい場所を見つけて、
            <br />
            あなたの旅をみんなと共有しよう。
          </p>

          {/* 旅行先検索 */}
          <form
            className="hero-search"
            onSubmit={handleSearch}
          >
            <input
              type="text"
              placeholder="旅行先・場所を検索"
              value={keyword}
              onChange={(event) =>
                setKeyword(event.target.value)
              }
            />

            <button type="submit">
              Search
            </button>
          </form>
        </div>

        {/* Hero Info Card */}
        <div className="hero-info-card">
          <span>NOW EXPLORING</span>

          <strong>Japan</strong>

          <p>
            Discover places,
            <br />
            share your journey.
          </p>

          <span className="hero-arrow">→</span>
        </div>
      </section>

      {/* =========================
          大陸選択
      ========================= */}
      <section className="explore-section" id="travel">
        <div className="section-heading">
          <div>
            <span className="section-label">
              EXPLORE THE WORLD
            </span>

            <h2>世界から旅先を探す</h2>

            <p>
              大陸を選択して、あなたの旅を見つけよう。
            </p>
          </div>
        </div>

        <div className="continent-grid">
          {continents.map((continent) => (
            <button
              key={continent.id}
              className={`continent-card ${
                selectedContinent === continent.id
                  ? "active"
                  : ""
              } ${!continent.available ? "disabled" : ""}`}
              onClick={() =>
                handleContinentSelect(continent)
              }
            >
              <span className="continent-name">
                {continent.name}
              </span>

              <span className="continent-ja">
                {continent.nameJa}
              </span>

              {!continent.available && (
                <span className="coming-soon">
                  準備中
                </span>
              )}
            </button>
          ))}
        </div>
      </section>

      {/* =========================
          アジアの国選択
          現在は日本のみ対応
      ========================= */}
      {selectedContinent === "asia" && (
        <section className="country-section">
          <div className="section-heading">
            <div>
              <span className="section-label">
                ASIA
              </span>

              <h2>アジアから旅先を探す</h2>

              <p>
                現在は日本の旅行情報を掲載しています。
              </p>
            </div>
          </div>

          <div className="country-grid">
            {asianCountries.map((country) => (
              <button
                key={country.id}
                className={`country-card ${
                  selectedCountry === country.id
                    ? "active"
                    : ""
                } ${
                  !country.available
                    ? "disabled"
                    : ""
                }`}
                onClick={() =>
                  handleCountrySelect(country)
                }
              >
                <span className="country-flag">
                  {country.flag}
                </span>

                <span className="country-name">
                  {country.name}
                </span>

                <span className="country-ja">
                  {country.nameJa}
                </span>

                {!country.available && (
                  <span className="coming-soon">
                    準備中
                  </span>
                )}
              </button>
            ))}
          </div>
        </section>
      )}

      {/* =========================
          日本の旅行先
      ========================= */}
      {selectedCountry === "japan" && (
        <section
          className="destination-section"
          id="places"
        >
          <div className="section-heading">
            <div>
              <span className="section-label">
                JAPAN
              </span>

              <h2>日本の人気旅行先</h2>

              <p>
                日本各地の旅行先やおすすめスポットを探してみよう。
              </p>
            </div>

            <a href="#" className="more-link">
              View all →
            </a>
          </div>

          <div className="destination-grid">
            {japanDestinations.map((destination) => (
              <article
                className="destination-card"
                key={destination.name}
              >
                <div className="destination-image">
                  <img
                    src={destination.image}
                    alt={destination.name}
                  />

                  <div className="destination-overlay">
                    <span>
                      {destination.english}
                    </span>

                    <h3>{destination.name}</h3>
                  </div>
                </div>

                <p>{destination.description}</p>
              </article>
            ))}
          </div>
        </section>
      )}

      {/* =========================
          人気投稿
      ========================= */}
      <section
        className="community-section"
        id="community"
      >
        <div className="section-heading">
          <div>
            <span className="section-label">
              COMMUNITY
            </span>

            <h2>人気の旅行投稿</h2>

            <p>
              旅をした人たちのリアルな体験を見つけてみよう。
            </p>
          </div>

          <a href="#" className="more-link">
            View all →
          </a>
        </div>

        <div className="post-grid">
          {popularPosts.map((post) => (
            <article
              className="post-card"
              key={post.title}
            >
              <span className="post-category">
                {post.category}
              </span>

              <h3>{post.title}</h3>

              <p>{post.description}</p>

              <div className="post-meta">
                <span>♡ {post.likes}</span>
                <span>💬 {post.comments}</span>
              </div>
            </article>
          ))}
        </div>
      </section>

      {/* =========================
          最新投稿
      ========================= */}
      <section className="latest-section">
        <div className="section-heading">
          <div>
            <span className="section-label">
              LATEST
            </span>

            <h2>最新の旅行投稿</h2>
          </div>

          <a href="#" className="more-link">
            View all →
          </a>
        </div>

        <div className="latest-post-list">
          {latestPosts.map((post) => (
            <article
              className="latest-post"
              key={post.title}
            >
              <span className="latest-category">
                {post.category}
              </span>

              <h3>{post.title}</h3>

              <time>{post.date}</time>
            </article>
          ))}
        </div>
      </section>
    </main>
  );
}

export default Home;