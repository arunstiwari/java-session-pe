package com.sapient.service;

import com.sapient.model.Employee;
import com.sapient.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepository;

    @Test
    void getEmployee() {
        assertNotNull(employeeRepository);
        Employee employee = new Employee("EMP-1","ABC", 24);

        Mockito.when(employeeRepository.getEmployee("ABC")).thenReturn(employee);

        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Employee abc = employeeService.getEmployee("ABC");

        verify(employeeRepository, times(1)).getEmployee("ABC");
        verify(employeeRepository, times(0)).fetchAllEmployees();


        Assertions.assertEquals(24,abc.getAge());
    }

    @Test
    void shouldThrowEmployeeNotFoundExceptionForInvalidEmployeeName() {
        assertNotNull(employeeRepository);
        Employee employee = new Employee("EMP-1","ABC", 24);

        Mockito.when(employeeRepository.getEmployee("ABC")).thenReturn(null);

        EmployeeService employeeService = new EmployeeService(employeeRepository);
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.getEmployee("ABC");
        });

        verify(employeeRepository, times(1)).getEmployee("ABC");
        verify(employeeRepository, times(1)).fetchAllEmployees();

    }
}