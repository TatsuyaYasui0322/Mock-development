package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleTestController {

    @GetMapping("/test")
    public String simpleTest() {
        return "Hello! Spring Bootが動いています！";
    }

    @GetMapping("/employee-test")
    public String employeeTest() {
        return "Employee.javaファイルが正常に読み込まれています！";
    }
}
