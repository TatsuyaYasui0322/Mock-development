import React from 'react';
import '../styles/employeeList.css';

function EmployeeList({ className, onShowDetail }) {
  return (
    <div id="employees" className={className}>
      <div className="header">
        <h1>社員一覧</h1>
        <div className="user-info">
          <span>ログイン : 田中太郎</span>
        </div>
      </div>
      <div className="content">
        <div className="filters">
          <div className="filter-group">
            <label>勤務地</label>
            <select>
              <option>全て</option>
              <option>東京本社</option>
              <option>大阪支社</option>
              <option>名古屋支社</option>
            </select>
          </div>
          <div className="filter-group">
            <label>部署</label>
            <select>
              <option>全て</option>
              <option>開発部</option>
              <option>営業部</option>
              <option>管理部</option>
            </select>
          </div>
          <div className="filter-group">
            <label>言語スキル</label>
            <select>
              <option>全て</option>
              <option>Java</option>
              <option>Python</option>
              <option>JavaScript</option>
            </select>
          </div>
          <div className="filter-group">
            <label>名前検索</label>
            <input type="text" placeholder="名前を入力" />
          </div>
        </div>
        <div className="table-container">
          <table>
            <thead>
              <tr>
                <th>社員ID</th>
                <th>名前</th>
                <th>部署</th>
                <th>勤務地</th>
                <th>言語スキル</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
              <tr
                onClick={() => onShowDetail('employee-detail')}
                style={{ cursor: 'pointer' }}
              >
                <td>EMP001</td>
                <td>田中太郎</td>
                <td>開発部</td>
                <td>東京本社</td>
                <td>Java, Python</td>
                <td>
                  <button
                    className="btn btn-secondary"
                    onClick={(e) => {
                      e.stopPropagation();
                      onShowDetail('employee-detail');
                    }}
                  >
                    詳細
                  </button>
                </td>
              </tr>
              <tr
                onClick={() => onShowDetail('employee-detail')}
                style={{ cursor: 'pointer' }}
              >
                <td>EMP002</td>
                <td>佐藤花子</td>
                <td>営業部</td>
                <td>大阪支社</td>
                <td>-</td>
                <td>
                  <button
                    className="btn btn-secondary"
                    onClick={(e) => {
                      e.stopPropagation();
                      onShowDetail('employee-detail');
                    }}
                  >
                    詳細
                  </button>
                </td>
              </tr>
              <tr
                onClick={() => onShowDetail('employee-detail')}
                style={{ cursor: 'pointer' }}
              >
                <td>EMP003</td>
                <td>山田次郎</td>
                <td>開発部</td>
                <td>東京本社</td>
                <td>JavaScript, React</td>
                <td>
                  <button
                    className="btn btn-secondary"
                    onClick={(e) => {
                      e.stopPropagation();
                      onShowDetail('employee-detail');
                    }}
                  >
                    詳細
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

export default EmployeeList;
