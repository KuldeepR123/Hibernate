package com.example.manyToManyRelationship;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();

        List<Employee> employees = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        Session session = factory.openSession();

        Employee e1 = new Employee();
        Employee e2 = new Employee();
        e1.setEmployee_id(1);
        e1.setEmployee_name("Kuldeep");

        e2.setEmployee_id(2);
        e2.setEmployee_name("Yash");

        Project p1 = new Project();
        Project p2 = new Project();

        p1.setProject_id(101);
        p1.setProject_name("Image Classification");

        p2.setProject_id(2);
        p2.setProject_name("Library Management System");

        Collections.addAll(employees,e1,e2);
        Collections.addAll(projects,p1,p2);

        e1.setProjectList(projects);
        e2.setProjectList(projects);

        p1.setEmployeList(employees);
        p2.setEmployeList(employees);

        Transaction tx = session.beginTransaction();

        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);
        tx.commit();


        session.close();
        factory.close();
    }
}
