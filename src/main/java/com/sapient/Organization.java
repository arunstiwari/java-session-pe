package com.sapient;

import com.sapient.calculator.AddThree;
import com.sapient.calculator.IPriceCalculator;
import com.sapient.calculator.IPriceCalculatorImpl;
import com.sapient.model.Department;
import com.sapient.model.Employee;
import com.sapient.model.Admin;
import com.sapient.model.Vendor;
import com.sapient.service.EmployeeService;

import java.sql.PreparedStatement;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Organization {

    public static void main(String[] args) {

        EmployeeService employeeService = new EmployeeService();
        Employee employee = new Employee("EMP-123", "Name-1",24);
        employeeService.addEmployee(employee);
        Map<String, Employee> employeeMap = new HashMap<>();

        employeeMap.put(employee.getEmployeeId(), employee);

        Employee employee3 = employeeMap.get(employee.getEmployeeId());
        List<? extends Admin> list1 = new ArrayList<>();
        List<? super Employee> list = new ArrayList<>();
        Admin admin = new Admin("EMP-234","ADMIN", 45);
        Vendor vendor = new Vendor("Vendor-123","vendor", 45);
        list.add(admin);
        list.add(vendor);

//        list1.add(employee);
//        List<Object> list1 = new ArrayList<>();

        List<Employee> allEmployees = employeeService.getAllEmployees();

        for (Employee employee1: allEmployees){
            System.out.println(employee1);
        }

        for (int i =0; i< allEmployees.size(); i++){
            Employee emp = allEmployees.get(i);
        }

//        GenericFactory<EmployeeService> factory = new GenericFactory<>(EmployeeService.class);
//        try {
//            EmployeeService employeeService1 = factory.createInstance();
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        GenericFactory<DepartmentService> departmentFactory = new GenericFactory<>(DepartmentService.class);
//        try {
//            DepartmentService employeeService1 = departmentFactory.createInstance();
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }


        Employee employee1 = new Employee("emp1", "name1", 21);
        List<Employee> employees = new ArrayList<>();
        Employee employee2 = EmployeeService.addAndGet(employee1, employees);
        System.out.println(employee2);

        Department department1 = new Department("dept1", "dept-1");
        List<Department> departments = new ArrayList<>();
        Department department = EmployeeService.addAndGet(department1, departments);
        System.out.println("department = " + department);

        //Functional Programming
        IPriceCalculator calculator = new IPriceCalculatorImpl();
        calculator.price();

        IPriceCalculator calculator1 = () -> 30;

        int price = calculator1.price();
        System.out.println("price = " + price);

        Function<Long, Long> addThree = new AddThree();
        Long result = addThree.apply(5l);
        System.out.println("result = " + result);


        Function<Long, Long> addThree1 = (value) -> value + 3;
        System.out.println(addThree1.apply(5l));


        Predicate predicate = (value) ->  value !=null;
        String xyz = null;
        System.out.println(predicate.test(xyz));

        Supplier<Integer> supplier = () -> 100;
        supplier.get();

        Predicate<String> startsWithB = (value) -> value.startsWith("B");
        Predicate<String> endsWithA = (value) -> value.endsWith("A");

        Predicate<String> startsWithBandEndsWithA = (value) -> startsWithB.test(value) && endsWithA.test(value);




    }
























}
