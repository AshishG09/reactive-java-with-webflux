package com.reactivedemo.reactivedemo.service;

import com.reactivedemo.reactivedemo.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> EMPLOYEE_LIST;

    public EmployeeServiceImpl() {
        this.EMPLOYEE_LIST = Arrays.asList(
                new Employee("Ram", 100, "Manager", "IT", LocalDate.of(2015, Month.OCTOBER, 11)),
                new Employee("Sam", 101, "Developer", "IT", LocalDate.of(2015, Month.OCTOBER, 11)),
                new Employee("Rob", 102, "Developer", "IT", LocalDate.of(2015, Month.OCTOBER, 11)),
                new Employee("Marley", 103, "CEO", "Management", LocalDate.of(2015, Month.OCTOBER, 11)),
                new Employee("Cathy", 104, "CTO", "Management", LocalDate.of(2015, Month.OCTOBER, 11)),
                new Employee("Sugar", 105, "VP", "Marketing", LocalDate.of(2015, Month.OCTOBER, 11)),
                new Employee("Rey", 106, "HR", "HR", LocalDate.of(2015, Month.OCTOBER, 11))
        );
    }

    @Override
    public Mono<Employee> findEmployeeById(Integer employeeId) {
        return Mono.just(this.EMPLOYEE_LIST.stream().filter(x -> x.getId() == employeeId).findFirst().get());
    }

    @Override
    public Flux<Employee> getAllEmployees() {
        return Flux.fromStream(this.EMPLOYEE_LIST.stream());
    }

    @Override
    public Flux<Employee> getEmployeesByDepartment(String department) {
        return Flux.fromStream(this.EMPLOYEE_LIST.stream().filter(x -> x.getDepartment().equalsIgnoreCase(department)));
    }

    @Override
    public Mono<Employee> updateEmployee(Employee employee) {
        return Mono.just(this.EMPLOYEE_LIST.set(
                this.EMPLOYEE_LIST.indexOf(
                        this.EMPLOYEE_LIST.stream().filter(x -> x.getId() == employee.getId()).findFirst().get()), employee));
    }

    @Override
    public Mono<Boolean> addEmployee(Employee employee) {
        return Mono.just(this.EMPLOYEE_LIST.add(employee));
    }
}
