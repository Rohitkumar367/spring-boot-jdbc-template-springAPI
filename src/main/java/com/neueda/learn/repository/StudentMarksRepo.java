package com.neueda.learn.repository;

import com.neueda.learn.entity.StudentMarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentMarksRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // CREATE
    public int addMarks(StudentMarks studentMarks) {

        String sql = """
                INSERT INTO marks(student_id, subject, marks, semester)
                VALUES (?, ?, ?, ?)
                """;

        return jdbcTemplate.update(
                sql,
                studentMarks.getStudentId(),
                studentMarks.getSubject(),
                studentMarks.getMarks(),
                studentMarks.getSemester()
        );
    }

    // READ ALL
    public List<StudentMarks> getAllMarks() {

        String sql = "SELECT * FROM marks";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(StudentMarks.class)
        );
    }

    // READ BY MARKS ID
    public StudentMarks getMarksById(int marksId) {

        String sql = "SELECT * FROM marks WHERE marks_id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(StudentMarks.class),
                marksId
        );
    }

    // READ BY STUDENT ID
    public List<StudentMarks> getMarksByStudentId(int studentId) {

        String sql = "SELECT * FROM marks WHERE student_id = ?";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(StudentMarks.class),
                studentId
        );
    }

    // UPDATE
    public int updateMarks(StudentMarks studentMarks) {

        String sql = """
                UPDATE marks
                SET student_id = ?,
                    subject = ?,
                    marks = ?,
                    semester = ?
                WHERE marks_id = ?
                """;

        return jdbcTemplate.update(
                sql,
                studentMarks.getStudentId(),
                studentMarks.getSubject(),
                studentMarks.getMarks(),
                studentMarks.getSemester(),
                studentMarks.getMarksId()
        );
    }

    // DELETE
    public int deleteMarks(int marksId) {

        String sql = "DELETE FROM marks WHERE marks_id = ?";

        return jdbcTemplate.update(sql, marksId);
    }
}