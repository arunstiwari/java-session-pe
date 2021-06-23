package com.sapient.model;

import java.util.HashSet;
import java.util.Set;

public class Department {
    private String departmentId;
    private String departmentName;
    private Set<Employee> employees;

    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.employees = new HashSet<>();
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }
}
