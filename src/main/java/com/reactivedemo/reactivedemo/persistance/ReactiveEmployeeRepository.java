package com.reactivedemo.reactivedemo.persistance;

import com.reactivedemo.reactivedemo.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ReactiveEmployeeRepository extends ReactiveCrudRepository<Employee, Integer> {
    Flux<Employee> findAllByDepartment();
}
