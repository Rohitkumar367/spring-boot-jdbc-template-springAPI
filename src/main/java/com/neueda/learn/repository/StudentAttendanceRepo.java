package com.neueda.learn.repository;

import com.neueda.learn.entity.StudentAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentAttendanceRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // CREATE
    public StudentAttendance markAttendance(StudentAttendance attendance) {

        String sql = """
                INSERT INTO attendance(student_id, attendance_date, status)
                VALUES (?, ?, ?)
                """;

        int result=jdbcTemplate.update(
                sql,
                attendance.getStudentId(),
                attendance.getAttendanceDate(),
                attendance.getStatus()
        );
        if(result>0){
            return attendance;
        }
        return null;
    }

    // READ ALL
    public List<StudentAttendance> getAllAttendance() {

        String sql = "SELECT * FROM attendance";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(StudentAttendance.class)
        );
    }

//    // READ BY ATTENDANCE ID
//    public StudentAttendance getAttendanceById(int attendanceId) {
//
//        String sql = "SELECT * FROM attendance WHERE attendance_id = ?";
//
//        return jdbcTemplate.queryForObject(
//                sql,
//                new BeanPropertyRowMapper<>(StudentAttendance.class),
//                attendanceId
//        );
//    }

    // READ BY STUDENT ID
    public List<StudentAttendance> getAttendanceByStudentId(int studentId) {

        String sql = "SELECT * FROM attendance WHERE student_id = ?";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(StudentAttendance.class),
                studentId
        );
    }

    // UPDATE
    public StudentAttendance updateAttendance(int id,StudentAttendance attendance) {

        String sql = """
                UPDATE attendance
                SET student_id = ?,
                    attendance_date = ?,
                    status = ?
                WHERE attendance_id = ?
                """;

        int result= jdbcTemplate.update(
                sql,
                attendance.getStudentId(),
                attendance.getAttendanceDate(),
                attendance.getStatus(),
                id
        );
        if(result>0){
            return attendance;
        }
        return null;
    }

    // DELETE
    public int deleteAttendance(int attendanceId) {

        String sql = "DELETE FROM attendance WHERE attendance_id = ?";

        return jdbcTemplate.update(sql, attendanceId);
    }
}
