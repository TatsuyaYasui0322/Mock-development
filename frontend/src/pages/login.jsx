import React from "react";

function Login({ onLogin }) {
  // 入力値の状態管理（例: useState）
  // const [userId, setUserId] = React.useState("");
  // const [password, setPassword] = React.useState("");
  // const [userType, setUserType] = React.useState("一般社員");

  // ログインボタン押下時の処理
  const handleLogin = (e) => {
    e.preventDefault();
    if (onLogin) onLogin();
  };

  return (
    <div id="login" className="screen active">
      <div className="login-form">
        <h2>社内管理システム</h2>
        <form onSubmit={handleLogin}>
          <div className="form-group">
            <label>社員ID</label>
            <input type="text" placeholder="社員IDを入力" />
          </div>
          <div className="form-group">
            <label>パスワード</label>
            <input type="password" placeholder="パスワードを入力" />
          </div>
          <div className="form-group">
            <label>ユーザー種別</label>
            <select>
              <option>一般社員</option>
              <option>管理者</option>
            </select>
          </div>
          <button className="btn" type="submit">
            ログイン
          </button>
        </form>
      </div>
    </div>
  );
}
export default Login;