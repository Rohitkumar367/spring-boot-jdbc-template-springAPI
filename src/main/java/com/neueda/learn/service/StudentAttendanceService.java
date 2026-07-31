package com.neueda.learn.service;

import com.neueda.learn.entity.StudentAttendance;
import com.neueda.learn.repository.StudentAttendanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAttendanceService {

    @Autowired
    private StudentAttendanceRepo studentAttendanceRepo;

    // CREATE
    public StudentAttendance markAttendance(StudentAttendance attendance) {
        return studentAttendanceRepo.markAttendance(attendance);
    }

    // READ ALL
    public List<StudentAttendance> getAllAttendance() {
        return studentAttendanceRepo.getAllAttendance();
    }

    // READ BY STUDENT ID
    public List<StudentAttendance> getAttendanceByStudentId(int studentId) {
        return studentAttendanceRepo.getAttendanceByStudentId(studentId);
    }

    // UPDATE
    public StudentAttendance updateAttendance(int id, StudentAttendance attendance) {
        return studentAttendanceRepo.updateAttendance(id, attendance);
    }

    // DELETE
    public int deleteAttendance(int attendanceId) {
        return studentAttendanceRepo.deleteAttendance(attendanceId);
    }
}