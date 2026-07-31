package com.neueda.learn;

import com.neueda.learn.entity.Employee;
import com.neueda.learn.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jdbc.test.autoconfigure.DataJdbcTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import org.junit.jupiter.api.*;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@DataJdbcTest // it tells spring that i am testing the database layer and it will configure the necessary beans for testing the repository layer
@Import(EmployeeRepo.class) // it tells spring to import the EmployeeRepo class and make it available for testing
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // this controls which database spring uses during testing. By default, spring uses an in-memory database for testing. But we want to use the actual database for testing, so we set it to NONE
public class EmployeeRepoTest
{
    @Autowired
    EmployeeRepo repo;

    @Test
    void shouldReturnAllEmployees() {
        List<Employee> employees = repo.getAllEmployees();
        assert(employees.size() > 0);
        assertFalse(employees.isEmpty());
    }
}
