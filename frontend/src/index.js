import React from 'react';
import ReactDOM from 'react-dom/client';
import Homepage from './components/common/Homepage';
import Login from './components/common/Login';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Login />
    <Homepage />
  </React.StrictMode>
);
