package com.sapient.model;

public final class EmployeeBuilder {
    private String departmentId;
    private String project;
    private String employeeId;
    private String name;
    private int age;

    private EmployeeBuilder() {
    }

    public static EmployeeBuilder anEmployee() {
        return new EmployeeBuilder();
    }

    public EmployeeBuilder withDepartmentId(String departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public EmployeeBuilder withProject(String project) {
        this.project = project;
        return this;
    }

    public EmployeeBuilder withEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public EmployeeBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public Employee build() {
        Employee employee = new Employee(employeeId, name, age);
        employee.setDepartmentId(departmentId);
        employee.setProject(project);
        return employee;
    }
}
