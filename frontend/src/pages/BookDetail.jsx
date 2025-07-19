import React from 'react';
import '../styles/bookDetail.css';

function BookDetail({ className }) {
    return (
        <>
    <div id="book-detail" className={className}>
      <div className="header">
        <h1>書籍詳細</h1>
        <div className="user-info">
          <span>ログイン : 田中太郎</span>
        </div>
      </div>
      <div className="content">
        <div className="detail-card">
          <div className="detail-header">
            <h2>Effective Java 第3版</h2>
            <div>
              <button className="btn btn-success">返却処理</button>
              <button className="btn btn-secondary">編集</button>
            </div>
          </div>
          <div className="detail-info">
            <div className="info-item">
              <div className="info-label">書籍ID</div>
              <div className="info-value">BOOK001</div>
            </div>
            <div className="info-item">
              <div className="info-label">著者</div>
              <div className="info-value">Joshua Bloch</div>
            </div>
            <div className="info-item">
              <div className="info-label">カテゴリー</div>
              <div className="info-value">プログラミング</div>
            </div>
            <div className="info-item">
              <div className="info-label">状態</div>
              <div className="info-value">
                <span className="status-indicator status-occupied" />
                貸出中
              </div>
            </div>
            <div className="info-item">
              <div className="info-label">貸出者</div>
              <div className="info-value">田中太郎 (EMP001)</div>
            </div>
            <div className="info-item">
              <div className="info-label">返却予定日</div>
              <div className="info-value">2024-07-15</div>
            </div>
          </div>
        </div>
        <div className="detail-card">
          <h3>書籍概要</h3>
          <p>
            Javaプログラマーのための必読書。Joshua
            Bloch氏によるJavaの効果的な使い方を詳しく解説。プログラマーの生産性向上とコード品質向上に役立つ実践的なテクニックが満載です。
          </p>
        </div>
        <div className="detail-card">
          <h3>貸出履歴</h3>
          <div className="table-container">
            <table>
              <thead>
                <tr>
                  <th>貸出者</th>
                  <th>貸出日</th>
                  <th>返却日</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>田中太郎</td>
                  <td>2024-06-15</td>
                  <td>貸出中</td>
                </tr>
                <tr>
                  <td>佐藤花子</td>
                  <td>2024-05-01</td>
                  <td>2024-05-28</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    </>
    );
}

export default BookDetail;
