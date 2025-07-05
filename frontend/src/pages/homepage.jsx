import React from "react";
import Dashboard from "./dashboard";
import Navigation from "./nabigation";
import Login from "./login";
import EmployeeList from "./employeeList";
import EmployeeDetail from "./employeeDetail";
import BookList from "./bookList";
import BookDetail from "./bookDetail";
import SeatList from "./seatList";
import SeatRegister from "./seatRegister";
import AddBook from "./addBook";
import AddEmployee from "./addEmployee";

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