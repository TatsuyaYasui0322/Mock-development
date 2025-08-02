package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book") // テーブル名を指定
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;
    
    @Column(name = "book_title", nullable = false, length = 255)
    private String bookTitle;
    
    @Column(name = "book_category", nullable = false, length = 100)
    private String bookCategory;
    
    @Column(name = "book_summary", nullable = false, length = 100)
    private String bookSummary;
    
    @Column(name = "book_author", nullable = false, length = 100)
    private String bookAuthor;
    
    @Column(name = "book_publisher", nullable = false, length = 100)
    private String bookPublisher;
    
    @Column(name = "publish_date", nullable = false)
    private LocalDate publishDate;
    
    @Column(name = "is_reserved", nullable = false)
    private Boolean isReserved = false;
    
    // 関連エンティティ
    @ManyToOne(fetch = FetchType.LAZY) // 多対一の関係 LAZYロード
    @JoinColumn(name = "reserved_id") //社員IDとの外部キー
    private Employee reservedBy;
    
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //idだけではないのでbook
    private List<Loan> loans;
    
    // デフォルトコンストラクタ
    public Book() {}
    
    // コンストラクタ 新しくデータを追加する際に使用
    public Book(String bookTitle, String bookCategory, String bookSummary, 
               String bookAuthor, String bookPublisher, LocalDate publishDate) {
        this.bookTitle = bookTitle;
        this.bookCategory = bookCategory;
        this.bookSummary = bookSummary;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.publishDate = publishDate;
        this.isReserved = false;
    }
    
    // Getter & Setter
    public Integer getBookId() {
        return bookId;
    }
    
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    
    public String getBookTitle() {
        return bookTitle;
    }
    
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    
    public String getBookCategory() {
        return bookCategory;
    }
    
    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }
    
    public String getBookSummary() {
        return bookSummary;
    }
    
    public void setBookSummary(String bookSummary) {
        this.bookSummary = bookSummary;
    }
    
    public String getBookAuthor() {
        return bookAuthor;
    }
    
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
    
    public String getBookPublisher() {
        return bookPublisher;
    }
    
    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }
    
    public LocalDate getPublishDate() {
        return publishDate;
    }
    
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
    
    public Boolean getIsReserved() {
        return isReserved;
    }
    
    public void setIsReserved(Boolean isReserved) {
        this.isReserved = isReserved;
    }
    
    public Employee getReservedBy() {
        return reservedBy;
    }
    
    public void setReservedBy(Employee reservedBy) {
        this.reservedBy = reservedBy;
    }
    
    public List<Loan> getLoans() {
        return loans;
    }
    
    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                ", bookSummary='" + bookSummary + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", publishDate=" + publishDate +
                ", isReserved=" + isReserved +
                '}';
    }
}
