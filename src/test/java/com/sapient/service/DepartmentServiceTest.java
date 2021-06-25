package com.sapient.service;

import com.sapient.model.Department;
import com.sapient.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    @Captor
    private ArgumentCaptor<Department>  departmentArgumentCaptor;

    @Test
    void addDepartment() {
        Department department = new Department("DEP-1","Store Dept");
        //Expectation
        doNothing().when(departmentRepository).addDepartment(department);
        //test invoke
        departmentService.addDepartment(department);

        //verification/assertions
        verify(departmentRepository,times(1)).addDepartment(department);
    }

    @Test
    void addDepartmentShouldThrowException() {
        Department department = new Department("DEP-1","Store Dept");
        //Expectation
        doThrow(RuntimeException.class).when(departmentRepository).addDepartment(department);
        //test invoke
        assertThrows(RuntimeException.class, () -> departmentService.addDepartment(department));

        //verification/assertions
        verify(departmentRepository,times(1)).addDepartment(department);
    }

    //Captor
    @Test
    void addDepartmentWithCaptor() {
        Department department = new Department("DEP-1","Store Dept");
        //Expectation
        doNothing().when(departmentRepository).addDepartment(department);
        //test invoke
        departmentService.addDepartment(department);

        //verification/assertions
        verify(departmentRepository,times(1)).addDepartment(department);
        verify(departmentRepository).addDepartment(departmentArgumentCaptor.capture());
        Department department1 = departmentArgumentCaptor.getValue();
        assertEquals(department,department1);
    }
}