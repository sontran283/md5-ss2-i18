package com.ra.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "stdudent")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int student_id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Classs classs;

    public Student() {
    }

    public Student(int student_id, String name, int age, String address, Classs classs) {
        this.student_id = student_id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.classs = classs;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Classs getClasss() {
        return classs;
    }

    public void setClasss(Classs classs) {
        this.classs = classs;
    }
}
