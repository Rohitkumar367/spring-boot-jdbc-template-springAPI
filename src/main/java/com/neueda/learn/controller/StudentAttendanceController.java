package com.neueda.learn.controller;

import com.neueda.learn.entity.StudentAttendance;
import com.neueda.learn.service.StudentAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class StudentAttendanceController {

    @Autowired
    private StudentAttendanceService studentAttendanceService;

    // CREATE
    @PostMapping
    public StudentAttendance markAttendance(@RequestBody StudentAttendance attendance) {
        return studentAttendanceService.markAttendance(attendance);
    }

    // READ ALL
    @GetMapping
    public List<StudentAttendance> getAllAttendance() {
        return studentAttendanceService.getAllAttendance();
    }

    // READ BY STUDENT ID
    @GetMapping("/student/{studentId}")
    public List<StudentAttendance> getAttendanceByStudentId(@PathVariable int studentId) {
        return studentAttendanceService.getAttendanceByStudentId(studentId);
    }

    // UPDATE
    @PutMapping("/{attendanceId}")
    public StudentAttendance updateAttendance(
            @PathVariable int attendanceId,
            @RequestBody StudentAttendance attendance) {

        return studentAttendanceService.updateAttendance(attendanceId, attendance);
    }

    // DELETE
    @DeleteMapping("/{attendanceId}")
    public int deleteAttendance(@PathVariable int attendanceId) {
        return studentAttendanceService.deleteAttendance(attendanceId);
    }
}