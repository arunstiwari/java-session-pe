package com.sapient;

import com.sapient.calculator.AddThree;
import com.sapient.calculator.IPriceCalculator;
import com.sapient.calculator.IPriceCalculatorImpl;
import com.sapient.model.*;
import com.sapient.repository.EmployeeRepository;
import com.sapient.service.EmployeeService;
import com.sapient.thread.MyThread;

import java.io.*;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Organization {

    public static void main(String[] args) throws FileNotFoundException {

        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
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

//        MyThread thread = new MyThread();
//        Thread t = new Thread(thread);
//        t.start();

        Runnable r = () -> {
            System.out.println("MyThread class run method");
            try {
                String name = Thread.currentThread().getName();
                System.out.println("name = " + name);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThread is finished");
        };
        Thread t1 = new Thread(r);
        t1.start();

        Thread t2 = new Thread(r);
        t2.start();


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


        Optional<Employee> first = Stream.of(employeesL)
                .filter((value) -> value.getAge() > 24)
                .findFirst();
        Employee employee4 = first.get();
        System.out.println("employee4 = " + employee4);

//               .map((value) -> {
//                    System.out.println("value = " + value);
//                     String aCase = value.getName().toUpperCase();
//                    value.setName(aCase);
//                    return value;
//                })
//               .forEach( (value) -> System.out.println("value in foreach = " + value));
//        System.out.println("count = " + count);

//        Stream.of(employeesL).map(addThree1)
//        while (true){
//
//        }
//        Employee employee6 = new Employee("")
         Employee employee5 = EmployeeBuilder.anEmployee()
                                    .withAge(34)
                                    .withEmployeeId("abc")
                                    .withName("cde")

//                                    .withProject("")
                                    .build();

         File file;
         InputStream inputStream = new BufferedInputStream( new FileInputStream("file.txt"));



    }




   private static Employee[] employeesL = {
            new Employee("123", "Emp1", 24),
           new Employee("456", "Emp2", 44),
           new Employee("167", "Emp3", 34),
   };









































}
