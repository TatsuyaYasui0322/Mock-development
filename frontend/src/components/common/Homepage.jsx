import React from "react";
import { useState } from "react";
import Dashboard from "../../pages/Dashboard1";
import Navigation from "./Navigation";
import EmployeeList from "../../pages/EmployeeList1";
import EmployeeDetail from "../../pages/EmployeeDetail1";
import BookList from "../../pages/BookList1";
import BookDetail from "../../pages/BookDetail1";
import SeatList from "../../pages/SeatList1";
import SeatRegister from "../../pages/SeatRegister1";
import AddBook from "../../pages/AaddBook";
import AddEmployee from "../../pages/AddEmployee1";

function Homepage() {
  const [activeScreen, setActiveScreen] = useState("dashboard");
  const handleNavClick = (screen) => {
    setActiveScreen(screen);
  };
  return (
    <>
      <Navigation activeScreen={activeScreen} onNavClick={handleNavClick} />
      <Dashboard className={activeScreen === "dashboard" ? "screen active" : "screen"} />
      <EmployeeList className={activeScreen === "employees" ? "screen active" : "screen"} />
      <EmployeeDetail className={activeScreen === "employee-detail" ? "screen active" : "screen"} />
      <BookList className={activeScreen === "books" ? "screen active" : "screen"} />
      <BookDetail className={activeScreen === "book-detail" ? "screen active" : "screen"} />
      <SeatList className={activeScreen === "seats" ? "screen active" : "screen"} />
      <SeatRegister className={activeScreen === "seat-register" ? "screen active" : "screen"} />
      <AddBook className={activeScreen === "add-book" ? "screen active" : "screen"} />
      <AddEmployee className={activeScreen === "add-employee" ? "screen active" : "screen"} />
    </>
  );
}

export default Homepage;
