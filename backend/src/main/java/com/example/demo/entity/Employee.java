package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @Column(name = "age", nullable = false)
    private Integer age;
    
    @Column(name = "birthplace", nullable = false, length = 100)
    private String birthplace;
    
    @Column(name = "work_location", nullable = false, length = 100)
    private String workLocation;
    
    @Column(name = "job_description", nullable = false, length = 500)
    private String jobDescription;
    
    @Column(name = "programming_languages", nullable = false, length = 100)
    private String programmingLanguages;
    
    // 関連エンティティ（無限ループを防ぐため @JsonIgnore を追加）
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Loan> loans;

    @OneToMany(mappedBy = "reservedBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Book> reservedBooks;

    @OneToMany(mappedBy = "usedBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Seat> usedSeats;
    
    // デフォルトコンストラクタ
    public Employee() {}
    
    // 全パラメータコンストラクタ
    public Employee(String name, Integer age, String birthplace, String workLocation, 
        String jobDescription, String programmingLanguages) {
        this.name = name;
        this.age = age;
        this.birthplace = birthplace;
        this.workLocation = workLocation;
        this.jobDescription = jobDescription;
        this.programmingLanguages = programmingLanguages;
    }
    
    // Getter & Setter
    public Integer getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getBirthplace() {
        return birthplace;
    }
    
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    
    public String getWorkLocation() {
        return workLocation;
    }
    
    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
    
    public String getJobDescription() {
        return jobDescription;
    }
    
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    
    public String getProgrammingLanguages() {
        return programmingLanguages;
    }
    
    public void setProgrammingLanguages(String programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }
    
    public List<Loan> getLoans() {
        return loans;
    }
    
    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
    
    public List<Book> getReservedBooks() {
        return reservedBooks;
    }
    
    public void setReservedBooks(List<Book> reservedBooks) {
        this.reservedBooks = reservedBooks;
    }
    
    public List<Seat> getUsedSeats() {
        return usedSeats;
    }
    
    public void setUsedSeats(List<Seat> usedSeats) {
        this.usedSeats = usedSeats;
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthplace='" + birthplace + '\'' +
                ", workLocation='" + workLocation + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", programmingLanguages='" + programmingLanguages + '\'' +
                '}';
    }
}
