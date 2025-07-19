import React from 'react';
import '../styles/bookList.css';

function BookList({ className }) {
  return (
    <>
    <div id="books" className={className}>
      <div className="header">
        <h1>書籍一覧</h1>
        <div className="user-info">
          <span>ログイン : 田中太郎</span>
        </div>
      </div>
      <div className="content">
        <div className="filters">
          <div className="filter-group">
            <label>カテゴリー</label>
            <select>
              <option>全て</option>
              <option>プログラミング</option>
              <option>データベース</option>
              <option>マネジメント</option>
              <option>デザイン</option>
            </select>
          </div>
          <div className="filter-group">
            <label>貸出状況</label>
            <select>
              <option>全て</option>
              <option>貸出可能</option>
              <option>貸出中</option>
            </select>
          </div>
          <div className="filter-group">
            <label>書籍検索</label>
            <input type="text" placeholder="タイトルまたは著者名" />
          </div>
        </div>
        <div className="table-container">
          <table>
            <thead>
              <tr>
                <th>書籍ID</th>
                <th>タイトル</th>
                <th>著者</th>
                <th>カテゴリー</th>
                <th>状態</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
              <tr
                onclick="showScreen('book-detail')"
                style={{ cursor: "pointer" }}
              >
                <td>BOOK001</td>
                <td>Effective Java 第3版</td>
                <td>Joshua Bloch</td>
                <td>プログラミング</td>
                <td>
                  <span className="status-indicator status-occupied" />
                  貸出中
                </td>
                <td>
                  <button className="btn btn-secondary">詳細</button>
                </td>
              </tr>
              <tr>
                <td>BOOK002</td>
                <td>Clean Architecture</td>
                <td>Robert C. Martin</td>
                <td>プログラミング</td>
                <td>
                  <span className="status-indicator status-available" />
                  貸出可能
                </td>
                <td>
                  <button className="btn btn-secondary">詳細</button>
                </td>
              </tr>
              <tr>
                <td>BOOK003</td>
                <td>データベース設計入門</td>
                <td>田中一郎</td>
                <td>データベース</td>
                <td>
                  <span className="status-indicator status-available" />
                  貸出可能
                </td>
                <td>
                  <button className="btn btn-secondary">詳細</button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    </>
    );
}

export default BookList;
