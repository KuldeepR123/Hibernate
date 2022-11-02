package com.example.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Course {
    @Column(name = "Course_Name")
    String courseName;
    @Column(name = "Language")
    String language;

    public Course(String courseName, String language) {
        this.courseName = courseName;
        this.language = language;
    }
    public Course(){}
}
