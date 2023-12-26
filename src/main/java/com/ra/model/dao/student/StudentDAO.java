package com.ra.model.dao.student;

import com.ra.model.entity.Classs;
import com.ra.model.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();

    void saveOrUpdate(Student student);

    void delete(Integer id);

    Student findById(Integer id);
}
