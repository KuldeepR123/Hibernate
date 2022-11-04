package com.example.hqlExample;

import com.example.hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class GetData {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

//        String select_query = "from Student";

        Transaction tx = session.beginTransaction();
       /* String str = "delete from Student where course_name =:x";
        Query query = session.createQuery(str);
        query.setParameter("x","Java");*/

        String update_query = "update Student set address=:c where name=:n";
        Query updateQuary = session.createQuery(update_query);
        updateQuary.setParameter("c","Mumbai");
        updateQuary.setParameter("n","Niraj");
        int i = updateQuary.executeUpdate();
        System.out.println(i);
        session.close();
        factory.close();
    }
}
