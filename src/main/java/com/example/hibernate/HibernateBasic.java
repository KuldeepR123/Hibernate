package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HibernateBasic {
    public static void main(String[] args) throws IOException {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Student student= new Student();
        student.setName("Kuldeep");
        student.setId(1);
        student.setAddress("Rajkot");

        FileInputStream fis = new FileInputStream("src/main/resources/download.jpeg");
        byte[] img = new byte[fis.available()];
        fis.read(img);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"Kuldeep","Rajkot",new Course("Machine Learning","English")));
        studentList.add(new Student(2,"Yash","Anandpar",new Course("C","English")));
        studentList.add(new Student(3,"Niraj","Rajkot",new Course("C++","English")));
        studentList.add(new Student(4,"Harsh","Rajkot", new Course("Java","English")));
        studentList.add(new Student(5,"AP","Rajkot",new Course("React","English")));

        List<StudentAddress> studentAddressList = new ArrayList<>();
        studentAddressList.add(new StudentAddress("Rajkot",1,true, new Date(),img));
        studentAddressList.add(new StudentAddress("Surat",2,false, new Date(),img));
        studentAddressList.add(new StudentAddress("Ahmedabad",4,false, new Date(),img));
        studentAddressList.add(new StudentAddress("Mumbai",5,true, new Date(),img));
        studentAddressList.add(new StudentAddress("Delhi",3,true, new Date(),img));
        System.out.println(student);

        Session session = factory.openSession();
        for(Student s:studentList){
            Transaction tx = session.beginTransaction();
            session.save(s);
            tx.commit();
        }
        for(StudentAddress s : studentAddressList){
            Transaction tx = session.beginTransaction();
            session.save(s);
            tx.commit();
        }
        session.close();
    }
}
