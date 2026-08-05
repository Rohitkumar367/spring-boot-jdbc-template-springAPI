package com.neueda.learn.service;

import com.neueda.learn.entity.Student;
import com.neueda.learn.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    // READ ALL
    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }


    // CREATE
    public Student addStudent(Student student) {
        return studentRepo.addStudent(student);
    }


    // READ BY ID
    public Student getStudentById(int id) {
        return studentRepo.getStudentById(id);
    }

    // UPDATE
    public Student updateStudent(int id,Student student) {
        return studentRepo.updateStudent(id,student);
    }

    // DELETE
    public String deleteStudent(int id) {
        Student st = studentRepo.getStudentById(id);
        if(st == null){
            return "Student with id " + id + " not found.";
        }
        return studentRepo.deleteStudent(id, st);
    }
}