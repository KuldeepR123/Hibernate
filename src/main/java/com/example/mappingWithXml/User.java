package com.example.mappingWithXml;

public class User {
    private int id;
    private String name;
    private String city;
    private String phone_number;

    public User() {
    }

    public User(int id, String name, String city, String phone_number) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
