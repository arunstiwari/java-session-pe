package com.sapient;

import com.sapient.model.Employee;
import com.sapient.service.EmployeeService;

import java.util.List;

public class Organization {

    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeService();
        Employee employee = new Employee("EMP-123", "Name-1",24);
        employeeService.addEmployee(employee);

        List<Employee> allEmployees = employeeService.getAllEmployees();

        for (Employee employee1: allEmployees){
            System.out.println(employee1);
        }


    }

}
