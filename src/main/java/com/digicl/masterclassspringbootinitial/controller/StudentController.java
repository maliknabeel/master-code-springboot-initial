package com.digicl.masterclassspringbootinitial.controller;

import com.digicl.masterclassspringbootinitial.modal.Student;
import com.digicl.masterclassspringbootinitial.services.StudentProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class StudentController {

    @Autowired
    private StudentProcessor studentProcessor;

    @GetMapping("/greetings")
    public String greetingsService() {
        return "Greetings from Spring Boot Student App!";
    }

    @PostMapping("/student")
    public String addNewStudent(@RequestBody Student student){
        return studentProcessor.addStudent(student);
    }

    @GetMapping("/student")
    public Student findStudent(@RequestParam int id){
        return studentProcessor.searchStudent(id);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student){
        return studentProcessor.updateInformation(student);
    }

    @DeleteMapping("/student")
    public String removeStudent(@RequestBody Student student){
        return studentProcessor.removeInformation(student);
    }
}