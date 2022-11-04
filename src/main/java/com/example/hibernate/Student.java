package com.example.hibernate;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Cacheable()
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private String address;
    private Course course;
    public Student(int id, String name, String address, Course course) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.id + " : " + this.name + " : " + this.course.courseName + " : " + this.course.language + " : " +  this.address;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student() {
    }
}
