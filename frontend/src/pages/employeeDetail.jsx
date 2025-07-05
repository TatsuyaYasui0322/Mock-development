import React from 'react';
import '../styles/employeeDetail.css';

function EmployeeDetail() {
  return (
    <>
{/* 4. 社員詳細画面 */}
    <div id="employee-detail" className="screen active">
      <div className="header">
        <h1>社員詳細</h1>
        <div className="user-info">
          <div className="user-avatar">田</div>
          <span>田中太郎</span>
        </div>
      </div>
      <div className="content">
        <div className="detail-card">
          <div className="detail-header">
            <h2>田中太郎 (EMP001)</h2>
            <button className="btn btn-secondary">編集</button>
          </div>
          <div className="detail-info">
            <div className="info-item">
              <div className="info-label">部署</div>
              <div className="info-value">開発部</div>
            </div>
            <div className="info-item">
              <div className="info-label">勤務地</div>
              <div className="info-value">東京本社</div>
            </div>
            <div className="info-item">
              <div className="info-label">言語スキル</div>
              <div className="info-value">Java, Python, SQL</div>
            </div>
            <div className="info-item">
              <div className="info-label">好きな言葉</div>
              <div className="info-value">「継続は力なり」</div>
            </div>
          </div>
        </div>
        <div className="detail-card">
          <h3>貸出中の書籍</h3>
          <div className="table-container">
            <table>
              <thead>
                <tr>
                  <th>書籍名</th>
                  <th>著者</th>
                  <th>貸出日</th>
                  <th>返却予定日</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Effective Java 第3版</td>
                  <td>Joshua Bloch</td>
                  <td>2024-06-15</td>
                  <td>2024-07-15</td>
                </tr>
                <tr>
                  <td>Clean Code</td>
                  <td>Robert C. Martin</td>
                  <td>2024-06-20</td>
                  <td>2024-07-20</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div className="detail-card">
          <h3>現在利用中の席</h3>
          <p>
            席番号: <strong>A-15</strong> | 使用開始: <strong>09:30</strong> |
            予定終了: <strong>18:00</strong>
          </p>
        </div>
      </div>
    </div>
    </>
    );
}
export default EmployeeDetail;