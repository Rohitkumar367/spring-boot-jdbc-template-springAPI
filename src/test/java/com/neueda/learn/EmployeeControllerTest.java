package com.neueda.learn;

import com.neueda.learn.controller.EmployeeController;
import com.neueda.learn.entity.Employee;
import com.neueda.learn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;


// load only the MVC layer and create a real Employee Controller
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest
{
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    EmployeeService service;

    @Test
    void shouldReturnAllEmployees() throws Exception
    {
        List<Employee> list = List.of(
            new Employee("John", "IT", 5000),
            new Employee("Jane", "HR", 6000)
        );

        when(service.getAllEmployees()).thenReturn(list);

        mockMvc.perform(get("/employees/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].name").value("John"));
    }

    @Test
    void shouldReturnMessageAndAllEmployeesWhenDataExists() throws Exception
    {
        List<Employee> list = List.of(
                new Employee("John", "IT", 5000),
                new Employee("Jane", "HR", 6000)
        );

        when(service.getAllEmployees()).thenReturn(list);

        mockMvc.perform(get("/employees/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Employees fetched successfully"))
                .andExpect(jsonPath("$.data.length()").value(2))
                .andExpect(jsonPath("$.data[1].name").value("Jane"));
    }

    @Test
    void shouldReturnEmptyDataListWhenNoEmployeesExist() throws Exception
    {
        when(service.getAllEmployees()).thenReturn(List.of());

        mockMvc.perform(get("/employees/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Employees fetched successfully"))
                .andExpect(jsonPath("$.data.length()").value(0));
    }

    @Test
    void shouldReturn201AndEmployeeWhenSaveSucceeds() throws Exception
    {
        when(service.saveEmployee(any(Employee.class))).thenReturn(1);

        mockMvc.perform(post("/employees/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John\",\"department\":\"IT\",\"salary\":5000}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Employee added successfully"))
                .andExpect(jsonPath("$.data.name").value("John"));
    }

    @Test
    void shouldReturn400WhenSaveEmployeeFails() throws Exception
    {
        when(service.saveEmployee(any(Employee.class))).thenReturn(0);

        mockMvc.perform(post("/employees/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John\",\"department\":\"IT\",\"salary\":5000}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Employee not added"));
    }

    @Test
    void shouldReturnEmployeeWhenFoundById() throws Exception
    {
        Employee employee = new Employee("John", "IT", 5000);
        employee.setId(1);
        when(service.getEmployeeById(1)).thenReturn(employee);

        mockMvc.perform(get("/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Employee fetched successfully"))
                .andExpect(jsonPath("$.data.name").value("John"))
                .andExpect(jsonPath("$.data.id").value(1));
    }

    @Test
    void shouldReturn404WhenEmployeeNotFoundById() throws Exception
    {
        when(service.getEmployeeById(99)).thenReturn(null);

        mockMvc.perform(get("/employees/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Employee not found"));
    }

    @Test
    void shouldReturn200AndUpdatedEmployeeWhenUpdateSucceeds() throws Exception
    {
        Employee updated = new Employee("John Updated", "Engineering", 7000);
        when(service.updateEmpoyee(eq(1), any(Employee.class))).thenReturn(updated);

        mockMvc.perform(put("/employees/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Updated\",\"department\":\"Engineering\",\"salary\":7000}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Employee updated successfully"))
                .andExpect(jsonPath("$.data.name").value("John Updated"));
    }

    @Test
    void shouldReturn400WhenUpdateFails() throws Exception
    {
        when(service.updateEmpoyee(eq(1), any(Employee.class))).thenReturn(null);

        mockMvc.perform(put("/employees/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Updated\",\"department\":\"Engineering\",\"salary\":7000}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Employee not updated"));
    }

    @Test
    void shouldReturn200WithMessageWhenDeleteSucceeds() throws Exception
    {
        when(service.deleteEmployee(1)).thenReturn(1);

        mockMvc.perform(delete("/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Employee deleted successfully"));
    }

    @Test
    void shouldReturn400WhenDeleteFails() throws Exception
    {
        when(service.deleteEmployee(1)).thenReturn(0);

        mockMvc.perform(delete("/employees/1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Employee not deleted"));
    }
}
