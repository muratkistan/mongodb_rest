package com.muratkistan.mongodbrest.controller;

import com.muratkistan.mongodbrest.model.Student;
import com.muratkistan.mongodbrest.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private  final StudentService studentService;



    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
