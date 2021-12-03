package com.reactivedemo.reactivedemo.controller;

import com.reactivedemo.reactivedemo.model.Employee;
import com.reactivedemo.reactivedemo.repository.EmployeeRepository;
import com.reactivedemo.reactivedemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    Flux<Employee> list() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    Mono<Employee> findById(Integer id) {
        return this.employeeService.findEmployeeById(id);
    }
}
