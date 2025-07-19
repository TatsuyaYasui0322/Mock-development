import React from "react";
import '../styles/addEmployee.css';

function AddEmployee({ className }) {
  return (
    <>
    <div id="add-employee" className={className}>
      <div className="header">
        <h1>社員登録</h1>
        <div className="user-info">
          <span>ログイン : 田中太郎</span>
        </div>
      </div>
      <div className="content">
        <div className="detail-card">
          <div className="detail-header">
            <h2>新規社員登録</h2>
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
                <label>社員ID *</label>
                <input
                  type="text"
                  placeholder="EMP004"
                  defaultValue="EMP004"
                  required=""
                />
              </div>
              <div className="form-group">
                <label>姓 *</label>
                <input type="text" placeholder="田中" required="" />
              </div>
              <div className="form-group">
                <label>名 *</label>
                <input type="text" placeholder="太郎" required="" />
              </div>
              <div className="form-group">
                <label>メールアドレス *</label>
                <input
                  type="email"
                  placeholder="tanaka@company.com"
                  required=""
                />
              </div>
              <div className="form-group">
                <label>電話番号</label>
                <input type="tel" placeholder="090-1234-5678" />
              </div>
            </div>
            <div>
              <div className="form-group">
                <label>部署 *</label>
                <select required="">
                  <option>選択してください</option>
                  <option>開発部</option>
                  <option>営業部</option>
                  <option>管理部</option>
                  <option>マーケティング部</option>
                  <option>人事部</option>
                </select>
              </div>
              <div className="form-group">
                <label>役職</label>
                <select>
                  <option>一般社員</option>
                  <option>主任</option>
                  <option>係長</option>
                  <option>課長</option>
                  <option>部長</option>
                </select>
              </div>
              <div className="form-group">
                <label>勤務地 *</label>
                <select required="">
                  <option>選択してください</option>
                  <option>東京本社</option>
                  <option>大阪支社</option>
                  <option>名古屋支社</option>
                  <option>福岡支社</option>
                </select>
              </div>
              <div className="form-group">
                <label>入社日</label>
                <input type="date" />
              </div>
              <div className="form-group">
                <label>ユーザー権限</label>
                <select>
                  <option>一般社員</option>
                  <option>管理者</option>
                </select>
              </div>
            </div>
          </div>
          <div className="form-group">
            <label>言語・技術スキル (カンマ区切り)</label>
            <input type="text" placeholder="Java, Python, JavaScript, React" />
          </div>
          <div className="form-group">
            <label>備考</label>
            <textarea
              style={{
                width: "100%",
                padding: 12,
                border: "2px solid #e5e7eb",
                borderRadius: 8,
                minHeight: 80,
                fontFamily: "inherit"
              }}
              placeholder="特記事項があれば入力"
              defaultValue={""}
            />
          </div>
          <div style={{ textAlign: "center", marginTop: 30 }}>
            <button className="btn btn-success">社員を登録</button>
            <button className="btn btn-secondary">キャンセル</button>
          </div>
        </div>
        <div className="detail-card">
          <h3>登録済み社員 (最新5件)</h3>
          <div className="table-container">
            <table>
              <thead>
                <tr>
                  <th>社員ID</th>
                  <th>名前</th>
                  <th>部署</th>
                  <th>登録日</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>EMP003</td>
                  <td>山田次郎</td>
                  <td>開発部</td>
                  <td>2024-06-28</td>
                  <td>
                    <button
                      className="btn btn-secondary"
                      style={{ fontSize: 12, padding: "6px 12px" }}
                    >
                      編集
                    </button>
                    <button
                      className="btn btn-danger"
                      style={{ fontSize: 12, padding: "6px 12px" }}
                    >
                      削除
                    </button>
                  </td>
                </tr>
                <tr>
                  <td>EMP002</td>
                  <td>佐藤花子</td>
                  <td>営業部</td>
                  <td>2024-06-25</td>
                  <td>
                    <button
                      className="btn btn-secondary"
                      style={{ fontSize: 12, padding: "6px 12px" }}
                    >
                      編集
                    </button>
                    <button
                      className="btn btn-danger"
                      style={{ fontSize: 12, padding: "6px 12px" }}
                    >
                      削除
                    </button>
                  </td>
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

export default AddEmployee;
