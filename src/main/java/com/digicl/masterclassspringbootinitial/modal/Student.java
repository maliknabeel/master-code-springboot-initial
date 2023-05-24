package com.digicl.masterclassspringbootinitial.modal;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class Student {
    private int studentId;
    private String studentName;
    private String studentAddress;
}