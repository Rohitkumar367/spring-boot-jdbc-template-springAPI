package com.neueda.learn.repository;

import com.neueda.learn.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // add Student
    public Student addStudent(Student student) {

        String sql = "INSERT INTO student(name, email, age, department, phone) VALUES (?, ?, ?, ?, ?)";

        int result= jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getAge(),
                student.getDepartment(),
                student.getPhone()
        );

        if(result>0){
            return student;
        }
        return null;
    }

    // READ ALL
    public List<Student> getAllStudents() {

        String sql = "SELECT * FROM student";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Student.class)
        );
    }

    // READ BY ID
    public Student getStudentById(int id) {

        String sql = "SELECT * FROM student WHERE id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Student.class),
                id
        );
    }

    // UPDATE
    public Student updateStudent(int id, Student student) {

        String sql = "UPDATE student SET name = ?, email = ?, age = ?, department = ?, phone = ? WHERE id = ?";

        int result= jdbcTemplate.update(
                sql,
                student.getName(),
                student.getEmail(),
                student.getAge(),
                student.getDepartment(),
                student.getPhone(),id
        );
        if(result>0){
            return student;
        }
        return null;
    }

    // DELETE
    public String deleteStudent(int id, Student student) {

        String sql = "DELETE FROM student WHERE id = ?";

        int result= jdbcTemplate.update(sql, id);
        if(result>0){
            return "Student with name " + student.getName() + "and id " + id + " deleted successfully.";
        }
        return "Failed to delete student with id " + id + ".";
    }
}
