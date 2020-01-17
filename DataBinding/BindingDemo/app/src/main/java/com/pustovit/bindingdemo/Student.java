package com.pustovit.bindingdemo;

/**
 * Created by Pustovit Vladimir on 17.01.2020.
 * vovapust1989@gmail.com
 */

public class Student {

    public Student(String studentName, String studentEmail) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
    }

    public Student() {
    }

    private String studentName;
    private String studentEmail;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
}
