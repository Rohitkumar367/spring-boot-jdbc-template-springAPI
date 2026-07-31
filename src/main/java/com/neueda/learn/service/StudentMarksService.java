package com.neueda.learn.service;

import com.neueda.learn.entity.StudentMarks;
import com.neueda.learn.repository.StudentMarksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMarksService {

    @Autowired
    private StudentMarksRepo studentMarksRepo;

    // CREATE
    public int addMarks(StudentMarks studentMarks) {
        return studentMarksRepo.addMarks(studentMarks);
    }

    // READ ALL
    public List<StudentMarks> getAllMarks() {
        return studentMarksRepo.getAllMarks();
    }

    // READ BY MARKS ID
    public StudentMarks getMarksById(int marksId) {
        return studentMarksRepo.getMarksById(marksId);
    }

    // READ BY STUDENT ID
    public List<StudentMarks> getMarksByStudentId(int studentId) {
        return studentMarksRepo.getMarksByStudentId(studentId);
    }

    // UPDATE
    public int updateMarks(StudentMarks studentMarks) {
        return studentMarksRepo.updateMarks(studentMarks);
    }

    // DELETE
    public int deleteMarks(int marksId) {
        return studentMarksRepo.deleteMarks(marksId);
    }
}