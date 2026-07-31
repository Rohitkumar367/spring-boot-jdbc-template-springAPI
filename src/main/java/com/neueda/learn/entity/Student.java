package com.neueda.learn.entity;


public class Student {

    private int id;
    private String name;
    private String email;
    private int age;
    private String department;
    private String phone;

    // Default Constructor
    public Student() {
    }

    // Parameterized Constructor
    public Student( String name, String email, int age, String department, String phone) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.department = department;
        this.phone = phone;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}