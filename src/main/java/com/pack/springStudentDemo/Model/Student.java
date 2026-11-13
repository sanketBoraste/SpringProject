package com.pack.springStudentDemo.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int rollno;
    private String name;
    private int age;
    private boolean active;
    private String email;
    private String subject;
    private String address;
    private Date CreatedDate;
    private Date ModifiedDate;

    public Student(Integer id, int rollno, String name, int age, String email, String subject, boolean active) {
        this.id = id;
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.email = email;
        this.subject = subject;
        this.active = active;
    }



    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
