package com.neueda.learn.service;

import com.neueda.learn.entity.Employee;
import com.neueda.learn.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepo empRepository;

    // get all employees
    public List<Employee> getAllEmployees() {
        return empRepository.getAllEmployees();
    }

    // save employee
    public int saveEmployee(Employee employee) {
        return empRepository.saveEmployee(employee) !=null ? 1 : 0;
    }

    // get employee by id
    public Employee getEmployeeById(int id){
        return empRepository.getEmployeeById(id);
    }
    // update user by id
    public Employee updateEmpoyee(int id, Employee employee){
        return empRepository.updateEmployee(id, employee);
    }
    // delete employee by id
    public int deleteEmployee(int id){
        return empRepository.deleteEmployee(id);
    }

}
