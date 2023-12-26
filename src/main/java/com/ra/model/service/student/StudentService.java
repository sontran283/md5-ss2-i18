package com.ra.model.service.student;

import com.ra.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    boolean saveOrUpdate(Student student);

    void delete(Integer id);

    Student findById(Integer id);
}
