// ...existing code from nabigation.jsx will be moved here...
import React from "react";
import '../../styles/navigation.css';

// ナビゲーションボタンのデータ
const navButtons = [
  { label: '1. ダッシュボード', screen: 'dashboard' },
  { label: '2. 社員一覧', screen: 'employees' },
  { label: '3. 社員詳細', screen: 'employee-detail' },
  { label: '4. 書籍一覧', screen: 'books' },
  { label: '5. 書籍詳細', screen: 'book-detail' },
  { label: '6. 席一覧', screen: 'seats' },
  { label: '7. 席登録', screen: 'seat-register' },
  { label: '8. 書籍追加', screen: 'add-book' },
  { label: '9. 社員登録', screen: 'add-employee' },
];

// props: activeScreen, onNavClick
function Navigation({ activeScreen, onNavClick }) {
  return (
    <div className="nav-buttons screen active" id="navigation-buttons">
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
