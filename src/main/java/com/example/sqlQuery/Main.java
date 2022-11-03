package com.example.sqlQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();

        Session session = factory.openSession();
        String str = "select distinct address from Student";
        NativeQuery nq = session.createSQLQuery(str);
        List<String> studentList = nq.list();
        for(String s:studentList){
            System.out.println(s);
        }
    }
}
