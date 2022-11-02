package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

//        Student st = (Student)session.get(Student.class,44);
        Student st1 = (Student)session.load(Student.class,5);
        System.out.println(st1);
        session.close();
        factory.close();
    }
}
