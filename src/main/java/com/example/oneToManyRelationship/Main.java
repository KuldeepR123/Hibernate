package com.example.oneToManyRelationship;

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


        questionList.add(new Question(101,"What are advantages of java ? ",answerList));

        answerList.add(new Answer(1,"Java is robust programming language",new Question(101,"What are advantages of java ? ",answerList)));
        answerList.add(new Answer(2,"Java is powerful. ",new Question(101,"What are advantages of java ? ",answerList)));
        answerList.add(new Answer(3,"Java is used for app development.",new Question(101,"What are advantages of java ? ",answerList)));

        Session session = factory.openSession();
        questionList.forEach(e->{
            Transaction tx = session.beginTransaction();
            session.save(e);
            tx.commit();
        });
        answerList.forEach(e->{
            Transaction tx = session.beginTransaction();
            session.save(e);
            tx.commit();
        });
        session.close();;
        factory.close();
    }
}
