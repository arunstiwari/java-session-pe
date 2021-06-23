package com.sapient.repository;

import com.sapient.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    List<Employee> employees = new ArrayList();

    public Employee getEmployee(String name) {

        return null;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> fetchAllEmployees() {
        return this.employees;
    }
}
