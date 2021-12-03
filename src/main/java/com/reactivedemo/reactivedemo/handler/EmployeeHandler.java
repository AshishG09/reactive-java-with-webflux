package com.reactivedemo.reactivedemo.handler;

import com.reactivedemo.reactivedemo.model.Employee;
import com.reactivedemo.reactivedemo.service.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class EmployeeHandler {
    private final EmployeeService employeeService;

    public EmployeeHandler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Mono<ServerResponse> getAllEmployees(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(employeeService.getAllEmployees(), Employee.class);
    }

    public Mono<ServerResponse> findEmployeeById(ServerRequest request){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(employeeService.findEmployeeById(Integer.valueOf(request.pathVariable("id"))), Employee.class);
    }

    public Mono<ServerResponse> addEmployee(ServerRequest request){
        Mono<Employee> employeeMono = request.bodyToMono(Employee.class);
        return ServerResponse
                .accepted()
                .contentType(MediaType.APPLICATION_JSON)
                .body( BodyInserters.fromPublisher(
                        employeeMono.flatMap(emp -> employeeService.addEmployee(emp)), Employee.class)
                );
    }
}
