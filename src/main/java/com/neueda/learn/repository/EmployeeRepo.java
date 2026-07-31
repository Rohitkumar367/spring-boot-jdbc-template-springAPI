package com.neueda.learn.repository;

import com.neueda.learn.entity.Employee;
import com.neueda.learn.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepo
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //get All Employees
    public List<Employee> getAllEmployees() {
        String sql="SELECT * FROM employees";
        return jdbcTemplate.query(
                sql,new BeanPropertyRowMapper<>(Employee.class)
        );
    }


    // Save Employee
    public Employee saveEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, department, salary) VALUES (?,?,?)";
        int result = jdbcTemplate.update(
                sql,
                employee.getName(),
                employee.getDepartment(),
                employee.getSalary());
        if (result > 0) {
            return employee;
        }else {
            return null;
        }
    }

    //get Employee by ID
    public Employee getEmployeeById(int id)
    {
        String sql = "SELECT * FROM employees WHERE id = ?";

        try{
            return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Employee.class),id);
        }catch(EmptyResultDataAccessException e){
            throw new EmployeeNotFoundException("Employees with id " + id + " not found");
        }
    }

    // update Employee
    public Employee updateEmployee(int id, Employee employee) {
        String sql = "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?";
        int result = jdbcTemplate.update(
                sql,
                employee.getName(),
                employee.getDepartment(),
                employee.getSalary(),
                id);
        if (result > 0) {
            return employee;
        }else {
            return null;
        }
    }

    // delete Employee
    public int deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        int result = jdbcTemplate.update(sql, id);
        if (result > 0) {
            return 1;
        }else {
            return 0;
        }
    }
}
