package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    
    // タイトルで検索（部分一致）
    List<Book> findByBookTitleContaining(String title);
    
    // 著者で検索（部分一致）
    List<Book> findByBookAuthorContaining(String author);
    
    // カテゴリで検索
    List<Book> findByBookCategory(String category);
    
    // 出版社で検索
    List<Book> findByBookPublisher(String publisher);
    
    // 予約状況で検索
    List<Book> findByIsReserved(Boolean isReserved);
    
    // 利用可能な書籍（予約されていない）
    List<Book> findByIsReservedFalse();
    
    // 予約済みの書籍
    List<Book> findByIsReservedTrue();
    
    // 出版日範囲で検索
    List<Book> findByPublishDateBetween(LocalDate startDate, LocalDate endDate);
    
    // 特定の社員が予約している書籍
    @Query("SELECT b FROM Book b WHERE b.reservedBy.employeeId = :employeeId")
    List<Book> findBooksReservedByEmployee(@Param("employeeId") Integer employeeId);
    
    // タイトルと著者で検索
    List<Book> findByBookTitleContainingAndBookAuthorContaining(String title, String author);
    
    // カテゴリ別の書籍数
    @Query("SELECT COUNT(b) FROM Book b WHERE b.bookCategory = :category")
    long countByCategory(@Param("category") String category);
    
    // 最新の書籍（出版日順）
    List<Book> findTop10ByOrderByPublishDateDesc();
    
    // タイトル順で並び替え
    List<Book> findAllByOrderByBookTitleAsc();
    
    // 著者順で並び替え
    List<Book> findAllByOrderByBookAuthorAsc();
    
    // 出版日順で並び替え（新しい順）
    List<Book> findAllByOrderByPublishDateDesc();
}
