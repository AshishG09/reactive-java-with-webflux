package com.reactivedemo.reactivedemo.controller;

import com.reactivedemo.reactivedemo.model.Employee;
import com.reactivedemo.reactivedemo.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employee")
    Flux<Employee> list() {
        return this.repository.findAll();
    }

    @GetMapping("/employee/{id}")
    Mono<Employee> findById() {
        return this.repository.findOne();
    }
}
