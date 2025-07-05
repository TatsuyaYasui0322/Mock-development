import React from 'react';
import '../styles/seatList.css';

function SeatList() {
  return (
    <>

{/* 7. 席一覧画面 */}
    <div id="seats" className="screen active">
      <div className="header">
        <h1>席一覧 - フロアA</h1>
        <div className="user-info">
          <div className="user-avatar">田</div>
          <span>田中太郎</span>
        </div>
      </div>
      <div className="content">
        <div className="filters">
          <div className="filter-group">
            <label>フロア</label>
            <select>
              <option>フロアA</option>
              <option>フロアB</option>
              <option>フロアC</option>
            </select>
          </div>
          <div className="filter-group">
            <label>状態</label>
            <select>
              <option>全て</option>
              <option>利用可能</option>
              <option>使用中</option>
            </select>
          </div>
        </div>
        <div className="card">
          <div style={{ display: "flex", gap: 20, marginBottom: 20 }}>
            <div>
              <span className="status-indicator status-available" />
              利用可能 (18席)
            </div>
            <div>
              <span className="status-indicator status-occupied" />
              使用中 (26席)
            </div>
          </div>
          <div className="seat-map">
            <div
              className="seat available"
              onclick="showScreen('seat-register')"
            >
              A1
            </div>
            <div className="seat occupied">
              A2
              <br />
              <small>田中</small>
            </div>
            <div
              className="seat available"
              onclick="showScreen('seat-register')"
            >
              A3
            </div>
            <div className="seat occupied">
              A4
              <br />
              <small>佐藤</small>
            </div>
            <div
              className="seat available"
              onclick="showScreen('seat-register')"
            >
              A5
            </div>
            <div className="seat occupied">
              A6
              <br />
              <small>山田</small>
            </div>
            <div
              className="seat available"
              onclick="showScreen('seat-register')"
            >
              A7
            </div>
            <div
              className="seat available"
              onclick="showScreen('seat-register')"
            >
              A8
            </div>
            <div className="seat occupied">
              A9
              <br />
              <small>鈴木</small>
            </div>
            <div
              className="seat available"
              onclick="showScreen('seat-register')"
            >
              A10
            </div>
            <div className="seat occupied">
              A11
              <br />
              <small>高橋</small>
            </div>
            <div
              className="seat available"
              onclick="showScreen('seat-register')"
            >
              A12
            </div>
            <div
              className="seat available"
              onclick="showScreen('seat-register')"
            >
              A13
            </div>
            <div className="seat occupied">
              A14
              <br />
              <small>中村</small>
            </div>
            <div className="seat occupied">
              A15
              <br />
              <small>田中</small>
            </div>
            <div
              className="seat available"
              onclick="showScreen('seat-register')"
            >
              A16
            </div>
          </div>
        </div>
      </div>
    </div>
    </>
    );
}

export default SeatList;