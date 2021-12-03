package com.reactivedemo.reactivedemo;

import static org.junit.jupiter.api.Assertions.*;
import com.reactivedemo.reactivedemo.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.Month;

@ExtendWith(SpringExtension.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReactivedemoApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void contextLoads() {
	}

	@Test
	public void testFunctionalGetEmployee(){
		webTestClient
				.get().uri("/functional/employee/100")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectBody(Employee.class).value( employee -> {
					Assertions.assertThat(employee.getId()).isEqualTo(100);
				});
	}

	@Test
	public void testFunctionalAddEmployee(){
		var newEmployee = new Employee("Vinay", 112, "COO", "Management", LocalDate.of(2018, Month.AUGUST, 21));
		webTestClient
				.post()
				.uri("/functional/employee")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(newEmployee), Employee.class)
				.exchange()
				.expectStatus().isAccepted()
				.expectBody(Employee.class).value( employee -> {
					Assertions.assertThat(employee.getId()).isEqualTo(112);
				});
	}

}
