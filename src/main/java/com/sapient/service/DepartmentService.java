package com.sapient.service;

import com.sapient.model.Department;
import com.sapient.repository.DepartmentRepository;

import java.util.List;

public class DepartmentService {

    private DepartmentRepository departmentRepistory;

    public DepartmentService(DepartmentRepository departmentRepistory) {
        this.departmentRepistory = departmentRepistory;
    }

    public List<Department> getAllDepartments() {
        return departmentRepistory.getAllDepartments();
    }

    public void addDepartment(Department department){
        departmentRepistory.addDepartment(department);
    }
}
