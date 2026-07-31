package com.neueda.learn;

import com.neueda.learn.entity.Employee;
import com.neueda.learn.exception.EmployeeNotFoundException;
import com.neueda.learn.repository.EmployeeRepo;
import com.neueda.learn.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*; // Mockito is a library used for creating fake objects

@ExtendWith(MockitoExtension.class) // this tells JUnit to use Mockito to create and manage mock objects
public class EmployeeServiceTest
{
    @Mock // creates a fake repository layer for testing
    EmployeeRepo repo; // Service layer -> fake repository layer

    @InjectMocks // creates the service layer and injects the fake repository into it
    EmployeeService service;

    @Test
    void shouldReturnAllEmployeesWhenRepositoryHasData()
    {
        List<Employee> employees = List.of(
                new Employee("John", "IT", 5000),
                new Employee("Jane", "HR", 6000)
        );

        when(repo.getAllEmployees()).thenReturn(employees);

        List<Employee> result = service.getAllEmployees();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        verify(repo).getAllEmployees();
    }

    @Test
    void shouldReturnEmptyEmployeeListWhenRepositoryHasNoData()
    {
        when(repo.getAllEmployees()).thenReturn(List.of());

        List<Employee> result = service.getAllEmployees();

        assertTrue(result.isEmpty());
        verify(repo).getAllEmployees();
    }

    @Test
    void shouldReturnOneWhenEmployeeIsSavedSuccessfully()
    {
        Employee employee = new Employee("John", "IT", 5000);
        when(repo.saveEmployee(employee)).thenReturn(employee);

        int result = service.saveEmployee(employee);

        assertEquals(1, result);
        verify(repo).saveEmployee(employee);
    }

    @Test
    void shouldReturnZeroWhenRepositoryDoesNotSaveEmployee()
    {
        Employee employee = new Employee("John", "IT", 5000);
        when(repo.saveEmployee(employee)).thenReturn(null);

        int result = service.saveEmployee(employee);

        assertEquals(0, result);
        verify(repo).saveEmployee(employee);
    }

    @Test
    void shouldReturnEmployeeByIdWhenRepositoryFindsEmployee()
    {
        Employee employee = new Employee("John", "IT", 5000);
        employee.setId(1);
        when(repo.getEmployeeById(1)).thenReturn(employee);

        Employee result = service.getEmployeeById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("John", result.getName());
        verify(repo).getEmployeeById(1);
    }

    @Test
    void shouldReturnNullWhenRepositoryDoesNotFindEmployee()
    {
        when(repo.getEmployeeById(99)).thenReturn(null);

        Employee result = service.getEmployeeById(99);

        assertNull(result);
        verify(repo).getEmployeeById(99);
    }

    @Test
    void shouldPropagateEmployeeNotFoundExceptionWhenRepositoryThrows()
    {
        when(repo.getEmployeeById(99)).thenThrow(new EmployeeNotFoundException("Employee with id 99 not found"));

        EmployeeNotFoundException exception = assertThrows(EmployeeNotFoundException.class, () -> service.getEmployeeById(99));

        assertEquals("Employee with id 99 not found", exception.getMessage());
        verify(repo).getEmployeeById(99);
    }

    @Test
    void shouldReturnUpdatedEmployeeWhenRepositoryUpdatesSuccessfully()
    {
        Employee employee = new Employee("John Updated", "Engineering", 7000);
        when(repo.updateEmployee(1, employee)).thenReturn(employee);

        Employee result = service.updateEmpoyee(1, employee);

        assertNotNull(result);
        assertEquals("John Updated", result.getName());
        verify(repo).updateEmployee(1, employee);
    }

    @Test
    void shouldReturnNullWhenRepositoryCannotUpdateEmployee()
    {
        Employee employee = new Employee("John Updated", "Engineering", 7000);
        when(repo.updateEmployee(1, employee)).thenReturn(null);

        Employee result = service.updateEmpoyee(1, employee);

        assertNull(result);
        verify(repo).updateEmployee(1, employee);
    }

    @Test
    void shouldReturnOneWhenRepositoryDeletesEmployee()
    {
        when(repo.deleteEmployee(1)).thenReturn(1);

        int result = service.deleteEmployee(1);

        assertEquals(1, result);
        verify(repo).deleteEmployee(1);
    }

    @Test
    void shouldReturnZeroWhenRepositoryCannotDeleteEmployee()
    {
        when(repo.deleteEmployee(1)).thenReturn(0);

        int result = service.deleteEmployee(1);

        assertEquals(0, result);
        verify(repo).deleteEmployee(1);
    }
}
