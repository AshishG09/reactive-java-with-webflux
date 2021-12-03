package com.reactivedemo.reactivedemo.model;

import java.time.LocalDate;
import java.util.Date;

public class Employee {
    String Name;
    Integer Id;
    String Role;
    String Department;
    LocalDate DateOfJoining;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public LocalDate getDateOfJoining() {
        return DateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        DateOfJoining = dateOfJoining;
    }

    public Employee(String name, Integer id, String role, String department, LocalDate dateOfJoining) {
        Name = name;
        Id = id;
        Role = role;
        Department = department;
        DateOfJoining = dateOfJoining;
    }

    public Employee() {}
}
