package com.reactivedemo.reactivedemo.config;

import com.reactivedemo.reactivedemo.handler.EmployeeHandler;
import jdk.jfr.ContentType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class FunctionalRouteConfig {
    @Bean
    public RouterFunction<ServerResponse> getMyFunctionalRoutes(EmployeeHandler handler){
        return RouterFunctions.route(GET("/functional/employee/{id}").and(accept(APPLICATION_JSON)), handler::findEmployeeById)
                .andRoute(GET("/functional/employee").and(accept(APPLICATION_JSON)),handler::getAllEmployees)
                .andRoute(POST("/functional/employee").and(contentType(APPLICATION_JSON)), handler::addEmployee);
    }
}