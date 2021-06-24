package com.sapient.service;

import com.sapient.model.Employee;
import com.sapient.repository.EmployeeRepository;

import java.util.Collection;
import java.util.List;

public class EmployeeService {

    private EmployeeRepository repository = new EmployeeRepository();


    public Employee getEmployee(String name) {
        Employee employee = repository.getEmployee(name);
        if (employee ==null){
            throw new EmployeeNotFoundException("Employee with name "+ name+ "Does not exist");
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return repository.fetchAllEmployees();
    }

    public void addEmployee(Employee employee){
        repository.addEmployee(employee);
    }

    public static <T> T addAndGet(T element, Collection<T> collection){
        collection.add(element);
        return element;
    }
}
