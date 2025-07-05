import React from 'react';
import '../styles/seatRegister.css';

function SeatRegister() {
  return (
    <>

{/* 8. 席登録・使用画面 */}
    <div id="seat-register" className="screen active">
      <div className="header">
        <h1>席登録・使用</h1>
        <div className="user-info">
          <div className="user-avatar">田</div>
          <span>田中太郎</span>
        </div>
      </div>
      <div className="content">
        <div className="detail-card">
          <div className="detail-header">
            <h2>席A1の使用登録</h2>
          </div>
          <div className="form-group">
            <label>使用開始時刻</label>
            <input type="datetime-local" defaultValue="2024-07-03T09:00" />
          </div>
          <div className="form-group">
            <label>使用終了予定時刻</label>
            <input type="datetime-local" defaultValue="2024-07-03T18:00" />
          </div>
          <div className="form-group">
            <label>利用目的</label>
            <select>
              <option>通常業務</option>
              <option>会議準備</option>
              <option>集中作業</option>
              <option>研修・学習</option>
            </select>
          </div>
          <div className="form-group">
            <label>備考</label>
            <input type="text" placeholder="特記事項があれば入力" />
          </div>
          <div style={{ textAlign: "center", marginTop: 20 }}>
            <button className="btn btn-success">使用開始</button>
            <button className="btn btn-secondary">キャンセル</button>
          </div>
        </div>
        <div className="detail-card">
          <h3>現在の使用状況</h3>
          <div className="table-container">
            <table>
              <thead>
                <tr>
                  <th>席番号</th>
                  <th>使用者</th>
                  <th>開始時刻</th>
                  <th>終了予定</th>
                  <th>残り時間</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>A15</td>
                  <td>田中太郎</td>
                  <td>09:30</td>
                  <td>18:00</td>
                  <td>7時間30分</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div style={{ textAlign: "center", marginTop: 15 }}>
            <button className="btn btn-danger">使用終了</button>
            <button className="btn btn-secondary">時間延長</button>
          </div>
        </div>
      </div>
    </div>
    </>
    );
}

export default SeatRegister;