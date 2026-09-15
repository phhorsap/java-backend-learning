package com.example.backend.controller;

import com.example.backend.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @GetMapping
    public List<Employee> getEmployees() {

        return List.of(
            new Employee(1L, "Anna", "IT"),
            new Employee(2L, "Max", "Production"),
            new Employee(3L, "Lisa", "Sales")
        );
    }
}