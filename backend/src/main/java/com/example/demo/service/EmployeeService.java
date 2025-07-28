package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    /**
     * 全社員を取得
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * IDで社員を取得
     */
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    /**
     * 社員を登録
     */
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * 社員情報を更新
     */
    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        return employeeRepository.findById(id)
        .map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setAge(updatedEmployee.getAge());
            employee.setBirthplace(updatedEmployee.getBirthplace());
            employee.setWorkLocation(updatedEmployee.getWorkLocation());
            employee.setJobDescription(updatedEmployee.getJobDescription());
            employee.setProgrammingLanguages(updatedEmployee.getProgrammingLanguages());
            return employeeRepository.save(employee);
        })
        .orElseThrow(() -> new RuntimeException("社員が見つかりません。ID: " + id));
    }

    /**
     * 社員を削除
     */
    public void deleteEmployee(Integer id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("社員が見つかりません。ID: " + id);
        }
    }
    /**
     * 名前で社員を検索（部分一致）
     */
    public List<Employee> searchEmployeesByName(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    /**
     * 勤務地で社員を検索
     */
    public List<Employee> getEmployeesByWorkLocation(String workLocation) {
        return employeeRepository.findByWorkLocation(workLocation);
    }

    /**
     * プログラミング言語で社員を検索
     */
    public List<Employee> getEmployeesBySkill(String skill) {
        return employeeRepository.findByProgrammingLanguagesContaining(skill);
    }

    /**
     * 年齢範囲で社員を検索
     */
    public List<Employee> getEmployeesByAgeRange(Integer minAge, Integer maxAge) {
        return employeeRepository.findByAgeBetween(minAge, maxAge);
    }

    /**
     * 勤務地とスキルで社員を検索
     */
    public List<Employee> getEmployeesByWorkLocationAndSkill(String workLocation, String skill) {
        return employeeRepository.findByWorkLocationAndSkill(workLocation, skill);
    }

    /**
     * 社員の総数を取得
     */
    public long getTotalEmployeeCount() {
        return employeeRepository.count();
    }

    /**
     * 特定の勤務地の社員数を取得
     */
    public long getEmployeeCountByWorkLocation(String workLocation) {
        return employeeRepository.countByWorkLocation(workLocation);
    }

    /**
     * 年齢順で社員リストを取得
     */
    public List<Employee> getEmployeesOrderByAge() {
        return employeeRepository.findAllByOrderByAgeAsc();
    }

    /**
     * 名前順で社員リストを取得
     */
    public List<Employee> getEmployeesOrderByName() {
        return employeeRepository.findAllByOrderByNameAsc();
    }

    /**
     * 社員が存在するかチェック
     */
    public boolean existsEmployee(Integer id) {
        return employeeRepository.existsById(id);
    }
}
