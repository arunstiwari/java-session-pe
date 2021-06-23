package com.sapient.model;

import java.util.StringJoiner;

public class Employee {
    private String employeeId;
    private String name;
    private int age;
    private String departmentId;

    private String project;

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("employeeId='" + employeeId + "'")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("departmentId='" + departmentId + "'")
                .add("project='" + project + "'")
                .toString();
    }

    public Employee(String employeeId, String name, int age) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getAge() {
        return age;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
