package com.neueda.learn.entity;

public class StudentMarks {

    private int marksId;
    private int studentId;
    private String subject;
    private int marks;
    private int semester;

    // Default Constructor
    public StudentMarks() {
    }

    // Parameterized Constructor
    public StudentMarks(int studentId, String subject, int marks, int semester) {
        this.studentId = studentId;
        this.subject = subject;
        this.marks = marks;
        this.semester = semester;
    }

    // Getters
    public int getMarksId() {
        return marksId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getSubject() {
        return subject;
    }

    public int getMarks() {
        return marks;
    }

    public int getSemester() {
        return semester;
    }

    // Setters
    public void setMarksId(int marksId) {
        this.marksId = marksId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "StudentMarks{" +
                "marksId=" + marksId +
                ", studentId=" + studentId +
                ", subject='" + subject + '\'' +
                ", marks=" + marks +
                ", semester=" + semester +
                '}';
    }
}