package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loan")
public class Loan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Integer loanId;
    
    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate;
    
    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;
    
    // 関連エンティティ
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    
    // デフォルトコンストラクタ
    public Loan() {}
    
    // コンストラクタ
    public Loan(Employee employee, Book book, LocalDate loanDate, LocalDate returnDate) {
        this.employee = employee;
        this.book = book;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }
    
    // Getter & Setter
    public Integer getLoanId() {
        return loanId;
    }
    
    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }
    
    public LocalDate getLoanDate() {
        return loanDate;
    }
    
    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }
    
    public LocalDate getReturnDate() {
        return returnDate;
    }
    
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    
    public Employee getEmployee() {
        return employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public Book getBook() {
        return book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
    
    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", employeeId=" + (employee != null ? employee.getEmployeeId() : null) +
                ", bookId=" + (book != null ? book.getBookId() : null) +
                '}';
    }
}
