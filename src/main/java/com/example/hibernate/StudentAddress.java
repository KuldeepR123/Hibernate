package com.example.hibernate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Student_Address")
public class StudentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "City")
    String city;
    int street_no;
    boolean isOpen;
    @Temporal(TemporalType.DATE)
    private Date date;
    byte[] image;

    public StudentAddress() {
    }
    public StudentAddress(String city, int street_no, boolean isOpen, Date date, byte[] image) {
        this.city = city;
        this.street_no = street_no;
        this.isOpen = isOpen;
        this.date = date;
        this.image = image;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStreet_no() {
        return street_no;
    }

    public void setStreet_no(int street_no) {
        this.street_no = street_no;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.id + " " + this.city + " " + this.street_no + " " + this.isOpen + " " + this.date;
    }
}
