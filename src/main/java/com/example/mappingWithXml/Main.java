package com.example.mappingWithXml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        User use1 = new User(1,"Kuldeep","rajkot","12345");
        Transaction tx = session.beginTransaction();
        session.save(use1);
        tx.commit();
        session.close();
        factory.close();
    }
}
