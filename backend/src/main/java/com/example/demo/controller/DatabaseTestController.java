package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*")
public class DatabaseTestController {
    @Autowired
    private EmployeeService employeeService;
    /**
     * データベース接続テスト
     * GET /api/test/connection
     */
    @GetMapping("/connection")
    public ResponseEntity<Map<String, Object>> testDatabaseConnection() {
        Map<String, Object> response = new HashMap<>();
        try {
            // 社員数を取得してDB接続をテスト
            long employeeCount = employeeService.getTotalEmployeeCount();
            response.put("status", "success");
            response.put("message", "データベースに正常に接続されました");
            response.put("employeeCount", employeeCount);
            response.put("timestamp", System.currentTimeMillis());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "データベース接続に失敗しました: " + e.getMessage());
            response.put("timestamp", System.currentTimeMillis());
            return ResponseEntity.status(500).body(response);
        }
    }
    /**
     * サンプルデータ取得テスト
     * GET /api/test/sample-data
     */
    @GetMapping("/sample-data")
    public ResponseEntity<Map<String, Object>> getSampleData() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            response.put("status", "success");
            response.put("message", "サンプルデータを正常に取得しました");
            response.put("employees", employees);
            response.put("totalCount", employees.size());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "データ取得に失敗しました: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
    /**
     * 新しい社員データを作成してテスト
     * POST /api/test/create-sample
     */
    @PostMapping("/create-sample")
    public ResponseEntity<Map<String, Object>> createSampleEmployee() {
        Map<String, Object> response = new HashMap<>();
        try {
            Employee newEmployee = new Employee();
            newEmployee.setName("テスト 花子");
            newEmployee.setAge(25);
            newEmployee.setBirthplace("大阪");
            newEmployee.setWorkLocation("大阪支社");
            newEmployee.setJobDescription("テスト用のサンプル社員データです。");
            newEmployee.setProgrammingLanguages("JavaScript, React, Node.js");
            Employee savedEmployee = employeeService.saveEmployee(newEmployee);
            response.put("status", "success");
            response.put("message", "新しい社員データを正常に作成しました");
            response.put("employee", savedEmployee);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "データ作成に失敗しました: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
