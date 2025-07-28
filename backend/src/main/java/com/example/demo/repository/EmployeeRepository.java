package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // 名前で検索（部分一致）
    List<Employee> findByNameContaining(String name);

    // 勤務地で検索
    List<Employee> findByWorkLocation(String workLocation);

    // 年齢範囲で検索
    List<Employee> findByAgeBetween(Integer minAge, Integer maxAge);

    // プログラミング言語で検索（部分一致）
    List<Employee> findByProgrammingLanguagesContaining(String language);

    // 複合検索：勤務地とスキルで検索
    @Query("SELECT e FROM Employee e WHERE e.workLocation = :workLocation AND e.programmingLanguages LIKE %:skill%")
    List<Employee> findByWorkLocationAndSkill(@Param("workLocation") String workLocation,
    @Param("skill") String skill);

    // 名前で社員を検索（完全一致）
    Optional<Employee> findByName(String name);

    // 特定の勤務地の社員数を取得
    @Query("SELECT COUNT(e) FROM Employee e WHERE e.workLocation = :workLocation")
    long countByWorkLocation(@Param("workLocation") String workLocation);

    // 年齢順で並び替え
    List<Employee> findAllByOrderByAgeAsc();

    // 名前順で並び替え
    List<Employee> findAllByOrderByNameAsc();

    // 勤務地別の社員リスト（勤務地順）
    List<Employee> findAllByOrderByWorkLocationAsc();
}
