package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*") // フロントエンドとの連携用
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    /**
     * 全社員を取得
     * GET /api/employees
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * IDで社員を取得
     * GET /api/employees/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        try {
            Optional<Employee> employee = employeeService.getEmployeeById(id);
            return employee.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * 新しい社員を登録
     * POST /api/employees
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee savedEmployee = employeeService.saveEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    /**
     * 社員情報を更新
     * PUT /api/employees/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, 
                                                 @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employee);
            return ResponseEntity.ok(updatedEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * 社員を削除
     * DELETE /api/employees/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * 名前で社員を検索
     * GET /api/employees/search?name={name}
     */
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployeesByName(@RequestParam String name) {
        try {
            List<Employee> employees = employeeService.searchEmployeesByName(name);
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * 勤務地で社員を検索
     * GET /api/employees/location/{workLocation}
     */
    @GetMapping("/location/{workLocation}")
    public ResponseEntity<List<Employee>> getEmployeesByWorkLocation(@PathVariable String workLocation) {
        try {
            List<Employee> employees = employeeService.getEmployeesByWorkLocation(workLocation);
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * プログラミング言語で社員を検索
     * GET /api/employees/skill/{skill}
     */
    @GetMapping("/skill/{skill}")
    public ResponseEntity<List<Employee>> getEmployeesBySkill(@PathVariable String skill) {
        try {
            List<Employee> employees = employeeService.getEmployeesBySkill(skill);
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * 年齢範囲で社員を検索
     * GET /api/employees/age?min={minAge}&max={maxAge}
     */
    @GetMapping("/age")
    public ResponseEntity<List<Employee>> getEmployeesByAgeRange(@RequestParam Integer min, 
                                                               @RequestParam Integer max) {
        try {
            List<Employee> employees = employeeService.getEmployeesByAgeRange(min, max);
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * 社員数を取得
     * GET /api/employees/count
     */
    @GetMapping("/count")
    public ResponseEntity<Long> getTotalEmployeeCount() {
        try {
            long count = employeeService.getTotalEmployeeCount();
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * 特定の勤務地の社員数を取得
     * GET /api/employees/count/location/{workLocation}
     */
    @GetMapping("/count/location/{workLocation}")
    public ResponseEntity<Long> getEmployeeCountByWorkLocation(@PathVariable String workLocation) {
        try {
            long count = employeeService.getEmployeeCountByWorkLocation(workLocation);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
