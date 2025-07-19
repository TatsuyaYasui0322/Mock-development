import React from "react";
import Dashboard from "./Dashboard1";
import Navigation from "./nabigation";
import Login from "./login";
import EmployeeList from "./EmployeeList1";
import EmployeeDetail from "./EmployeeDetail1";
import BookList from "./BookList1";
import BookDetail from "./BookDetail1";
import SeatList from "./SeatList";
import SeatRegister from "./SeatRegister";
import AddBook from "./AaddBook";
import AddEmployee from "./AddEmployee1";

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
