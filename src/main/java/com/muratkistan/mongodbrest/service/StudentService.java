package com.muratkistan.mongodbrest.service;

import com.muratkistan.mongodbrest.model.Student;
import com.muratkistan.mongodbrest.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
