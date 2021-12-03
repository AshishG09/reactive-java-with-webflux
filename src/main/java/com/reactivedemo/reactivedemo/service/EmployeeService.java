package com.reactivedemo.reactivedemo.service;

import com.reactivedemo.reactivedemo.model.Employee;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Component
public interface EmployeeService {
    Mono<Employee> findEmployeeById(Integer employeeId);
    Flux<Employee> getAllEmployees();
    Flux<Employee> getEmployeesByDepartment(String department);
    Mono<Employee> updateEmployee(Employee employee);
    Mono<Employee> addEmployee(Employee employee);
}
