import React from 'react';

function AddBook() {
  return (
    <>

{/* 9. 書籍追加画面（管理者） */}
    <div id="add-book" className="screen active">
      <div className="header">
        <h1>書籍追加 (管理者)</h1>
        <div className="user-info">
          <div className="user-avatar">田</div>
          <span>田中太郎 (管理者)</span>
        </div>
      </div>
      <div className="content">
        <div className="detail-card">
          <div className="detail-header">
            <h2>新規書籍登録</h2>
          </div>
          <div
            style={{
              display: "grid",
              gridTemplateColumns: "repeat(auto-fit, minmax(300px, 1fr))",
              gap: 20
            }}
          >
            <div>
              <div className="form-group">
                <label>書籍ID</label>
                <input
                  type="text"
                  placeholder="BOOK004"
                  defaultValue="BOOK004"
                />
              </div>
              <div className="form-group">
                <label>タイトル *</label>
                <input
                  type="text"
                  placeholder="書籍タイトルを入力"
                  required=""
                />
              </div>
              <div className="form-group">
                <label>著者 *</label>
                <input type="text" placeholder="著者名を入力" required="" />
              </div>
              <div className="form-group">
                <label>カテゴリー *</label>
                <select required="">
                  <option>選択してください</option>
                  <option>プログラミング</option>
                  <option>データベース</option>
                  <option>マネジメント</option>
                  <option>デザイン</option>
                  <option>マーケティング</option>
                  <option>その他</option>
                </select>
              </div>
            </div>
            <div>
              <div className="form-group">
                <label>出版社</label>
                <input type="text" placeholder="出版社名" />
              </div>
              <div className="form-group">
                <label>出版年</label>
                <input type="number" placeholder={2024} min={1900} max={2024} />
              </div>
              <div className="form-group">
                <label>ISBN</label>
                <input type="text" placeholder="978-4-XXXXXXXXX" />
              </div>
              <div className="form-group">
                <label>言語</label>
                <select>
                  <option>日本語</option>
                  <option>英語</option>
                  <option>その他</option>
                </select>
              </div>
            </div>
          </div>
          <div className="form-group">
            <label>概要・説明</label>
            <textarea
              style={{
                width: "100%",
                padding: 12,
                border: "2px solid #e5e7eb",
                borderRadius: 8,
                minHeight: 100,
                fontFamily: "inherit"
              }}
              placeholder="書籍の概要や内容について説明してください"
              defaultValue={""}
            />
          </div>
          <div className="form-group">
            <label>タグ (カンマ区切り)</label>
            <input type="text" placeholder="Java, プログラミング, 入門書" />
          </div>
          <div style={{ textAlign: "center", marginTop: 30 }}>
            <button className="btn btn-success">書籍を登録</button>
            <button className="btn btn-secondary">キャンセル</button>
          </div>
        </div>
      </div>
    </div>
    </>
  );
}

export default AddBook;