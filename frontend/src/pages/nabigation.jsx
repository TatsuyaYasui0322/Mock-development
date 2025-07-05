import React from "react";

// ナビゲーションボタンのデータ
const navButtons = [
  { label: '1. ログイン', screen: 'login' },
  { label: '2. ダッシュボード', screen: 'dashboard' },
  { label: '3. 社員一覧', screen: 'employees' },
  { label: '4. 社員詳細', screen: 'employee-detail' },
  { label: '5. 書籍一覧', screen: 'books' },
  { label: '6. 書籍詳細', screen: 'book-detail' },
  { label: '7. 席一覧', screen: 'seats' },
  { label: '8. 席登録', screen: 'seat-register' },
  { label: '9. 書籍追加', screen: 'add-book' },
  { label: '10. 社員登録', screen: 'add-employee' },
];

// props: activeScreen, onNavClick
function Navigation({ activeScreen, onNavClick }) {
  return (
    <div className="nav-buttons">
      {navButtons.map((btn) => (
        <button
          key={btn.screen}
          className={`nav-btn${activeScreen === btn.screen ? " active" : ""}`}
          onClick={() => onNavClick(btn.screen)}
        >
          {btn.label}
        </button>
      ))}
    </div>
  );
}

export default Navigation;