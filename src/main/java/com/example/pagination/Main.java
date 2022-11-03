package com.example.pagination;

import com.example.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();

        Session session = factory.openSession();
        String str = "from Student";
        Query query = session.createQuery(str);

        // where to start
        query.setFirstResult(0);
        // where to end
        query.setMaxResults(4);

        List<Student> studentList = query.list();
        studentList.forEach(s-> System.out.println(s.toString()));
    }
}
