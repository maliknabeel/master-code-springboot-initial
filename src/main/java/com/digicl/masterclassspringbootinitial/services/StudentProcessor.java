package com.digicl.masterclassspringbootinitial.services;

import com.digicl.masterclassspringbootinitial.modal.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StudentProcessor {

    private static final List<Student> studentList = new ArrayList<>();

    public String addStudent(Student student){
        studentList.add(student);

        log.info("Student id is {}", student.getStudentId());
        log.info("Student name is {}", student.getStudentName());
        log.info("Student address is {}", student.getStudentAddress());

        return "Student Added Successfully";
    }

    public Student searchStudent(int id){
        boolean statusFound = Boolean.FALSE;
        for (Student student: studentList) {
            if(student.getStudentId() == id){
                statusFound = Boolean.TRUE;
                log.info("Student id is {}", student.getStudentId());
                log.info("Student name is {}", student.getStudentName());
                log.info("Student address is {}", student.getStudentAddress());

                return student;
            }
        }

        if(!statusFound){
            log.info("Student Record Not Found");
        }
        return null;
    }

    public Student updateInformation(Student student){
        boolean statusFound = Boolean.FALSE;
        for (Student studentItr: studentList) {
            if(studentItr.getStudentId() == student.getStudentId()){
                statusFound = Boolean.TRUE;

                studentItr.setStudentName(student.getStudentName());
                studentItr.setStudentAddress(student.getStudentAddress());

                log.info("Student id is {}", studentItr.getStudentId());
                log.info("Student name is {}", studentItr.getStudentName());
                log.info("Student address is {}", studentItr.getStudentAddress());

                return studentItr;
            }
        }

        if(!statusFound){
            log.info("Student Record Not Found for Update");
        }

        return null;
    }

    public String removeInformation(Student student){
        boolean statusRemove = Boolean.FALSE;
        statusRemove = studentList.remove(student);
        if(statusRemove){
            log.info("Student Record Removed");
            return "Student Record Removed";

        }else{
            log.info("Student Record Not Found for Removal");
            return "Student Record Not Found";
        }
    }
}