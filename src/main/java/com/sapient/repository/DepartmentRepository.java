package com.sapient.repository;

import com.sapient.model.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    private List<Department> departments = new ArrayList<>();

    public List<Department> getAllDepartments() {
        return this.departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }
}
