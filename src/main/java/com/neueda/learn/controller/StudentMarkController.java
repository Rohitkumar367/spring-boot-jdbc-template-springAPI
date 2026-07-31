package com.neueda.learn.controller;

import com.neueda.learn.entity.StudentMarks;
import com.neueda.learn.service.StudentMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
@CrossOrigin(origins = "http://10.9.70.153:8082")
public class StudentMarkController {

    @Autowired
    private StudentMarksService studentMarksService;

    // CREATE
    @PostMapping
    public int addMarks(@RequestBody StudentMarks studentMarks) {
        return studentMarksService.addMarks(studentMarks);
    }

    // READ ALL
    @GetMapping
    public List<StudentMarks> getAllMarks() {
        return studentMarksService.getAllMarks();
    }

    // READ BY MARKS ID
    @GetMapping("/{marksId}")
    public StudentMarks getMarksById(@PathVariable int marksId) {
        return studentMarksService.getMarksById(marksId);
    }

    // READ BY STUDENT ID
    @GetMapping("/student/{studentId}")
    public List<StudentMarks> getMarksByStudentId(@PathVariable int studentId) {
        return studentMarksService.getMarksByStudentId(studentId);
    }

    // UPDATE
    @PutMapping("/{marksId}")
    public int updateMarks(@PathVariable int marksId, @RequestBody StudentMarks studentMarks) {
        studentMarks.setMarksId(marksId);
        return studentMarksService.updateMarks(studentMarks);
    }

    // DELETE
    @DeleteMapping("/{marksId}")
    public int deleteMarks(@PathVariable int marksId) {
        return studentMarksService.deleteMarks(marksId);
    }
}