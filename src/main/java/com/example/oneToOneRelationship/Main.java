package com.example.oneToOneRelationship;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();

        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();


        questionList.add(new Question(101,"what is java ? ",new Answer(1,"Java is programming language")));
        questionList.add(new Question(102,"which language is use for Machine Learning ? ",new Answer(2,"Python ")));
        questionList.add(new Question(103,"which language is use for Deep Learning ? ",new Answer(3,"C++ & Python")));

        answerList.add(new Answer(1,"Java is programming language"));
        answerList.add(new Answer(2,"Python "));
        answerList.add(new Answer(3,"C++ & Python"));
        Session session = factory.openSession();


        for(Answer a:answerList){
            Transaction tx = session.beginTransaction();
            session.save(a);
            tx.commit();
        }
        for (Question q:questionList){
            Transaction tx = session.beginTransaction();
            session.save(q);
            tx.commit();
        }
        session.close();;
        factory.close();
    }
}
