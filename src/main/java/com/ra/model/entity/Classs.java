package com.ra.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "classs")
public class Classs {
    @Id
    @Column(name = "class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String className;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "classs")
    private Set<Student> student;

    public Classs() {
    }

    public Classs(Integer id, String className, Boolean status, Set<Student> student) {
        this.id = id;
        this.className = className;
        this.status = status;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }
}
