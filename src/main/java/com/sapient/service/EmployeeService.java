package com.sapient.service;

import com.sapient.model.Employee;
import com.sapient.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    private EmployeeRepository repository = new EmployeeRepository();


    public Employee getEmployee(String name){
        return repository.getEmployee(name);
    }

    public List<Employee> getAllEmployees() {
        return repository.fetchAllEmployees();
    }

    public void addEmployee(Employee employee){
        repository.addEmployee(employee);
    }
}
