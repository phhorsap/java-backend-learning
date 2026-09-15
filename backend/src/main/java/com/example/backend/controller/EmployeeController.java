package com.example.backend.controller;

import com.example.backend.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final List<Employee> employees = List.of(
        new Employee(1L, "Anna", "IT"),
        new Employee(2L, "Max", "Production"),
        new Employee(3L, "Lisa", "Sales")
    );

    // GET /api/employees
    @GetMapping
    public List<Employee> getEmployees() {
        return employees;
    }

    // GET /api/employees/1
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable Long id) {

        return employees.stream()
            .filter(employee -> employee.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}