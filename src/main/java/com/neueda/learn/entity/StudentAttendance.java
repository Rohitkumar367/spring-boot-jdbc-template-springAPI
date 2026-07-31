package com.neueda.learn.entity;

import java.time.LocalDate;

public class StudentAttendance {

    private int attendanceId;
    private int studentId;
    private LocalDate attendanceDate;
    private String status;

    // Default Constructor
    public StudentAttendance() {
    }

    // Parameterized Constructor
    public StudentAttendance(int studentId, LocalDate attendanceDate, String status) {
        this.studentId = studentId;
        this.attendanceDate = attendanceDate;
        this.status = status;
    }

    // Getters
    public int getAttendanceId() {
        return attendanceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentAttendance{" +
                "attendanceId=" + attendanceId +
                ", studentId=" + studentId +
                ", attendanceDate=" + attendanceDate +
                ", status='" + status + '\'' +
                '}';
    }
}