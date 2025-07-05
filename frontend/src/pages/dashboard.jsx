import React from 'react';

function Dashboard() {
    return (
        <div id="dashboard" className=" screen active">
            <div className="header">
                <h1>ダッシュボード</h1>
                <div className="user-info">
                    <div className="user-avatar">田</div>
                    <span>田中太郎 (管理者)</span>
                </div>
            </div>
            <div className="content">
                <div className="dashboard-grid">
                    <div className="card">
                        <h3>総社員数</h3>
                        <div className="card-value">156人</div>
                    </div>
                    <div className="card">
                        <h3>貸出中の書籍</h3>
                        <div className="card-value">42冊</div>
                    </div>
                    <div className="card">
                        <h3>利用可能席</h3>
                        <div className="card-value">18席</div>
                    </div>
                    <div className="card">
                        <h3>使用中席</h3>
                        <div className="card-value">26席</div>
                    </div>
                </div>
                <div className="table-container">
                    <table>
                        <thead>
                            <tr>
                                <th>項目</th>
                                <th>状況</th>
                                <th>詳細</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>今日の新規貸出</td>
                                <td>8冊</td>
                                <td>前日比 +2冊</td>
                            </tr>
                            <tr>
                                <td>返却予定（本日）</td>
                                <td>5冊</td>
                                <td>未返却: 1冊</td>
                            </tr>
                            <tr>
                                <td>席利用率</td>
                                <td>59%</td>
                                <td>ピーク時間: 14:00-16:00</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

export default Dashboard;