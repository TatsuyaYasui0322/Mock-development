import React from "react";
import Dashboard from "./Dashboard";
import Navigation from "./nabigation";
import Login from "./login";
import EmployeeList from "./EmployeeList";
import EmployeeDetail from "./EmployeeDetail";
import BookList from "./BookList";
import BookDetail from "./BookDetail";
import SeatList from "./SeatList";
import SeatRegister from "./SeatRegister";
import AddBook from "./AaddBook";
import AddEmployee from "./AddEmployee";

function Homepage() {
  return (
    <>
  <meta charSet="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>社内管理システム</title>
  <div className="container">
    <Navigation />
    <Login />
    <Dashboard />
    <EmployeeList />
    <EmployeeDetail />
    <BookList />
    <BookDetail />
    <SeatList />
    <SeatRegister />
    <AddBook />
    <AddEmployee />
  </div>
</>
  );
}

export default Homepage;
