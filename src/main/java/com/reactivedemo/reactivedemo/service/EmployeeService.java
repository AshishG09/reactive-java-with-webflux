package com.reactivedemo.reactivedemo.service;

import com.reactivedemo.reactivedemo.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<Employee> findEmployeeById(Integer employeeId);
    Flux<Employee> getAllEmployees();
    Flux<Employee> getEmployeesByDepartment(String department);
    Mono<Employee> updateEmployee(Employee employee);
    Mono<Boolean> addEmployee(Employee employee);
}
