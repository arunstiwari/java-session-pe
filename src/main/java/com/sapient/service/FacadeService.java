package com.sapient.service;

public class FacadeService {
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    public FacadeService(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    public void businessWorkflow(){
        this.departmentService.addDepartment(null);
        this.employeeService.addEmployee(null);
    }
}
