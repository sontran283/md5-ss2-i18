package com.ra.model.service.student;

import com.ra.model.dao.student.StudentDAO;
import com.ra.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public boolean saveOrUpdate(Student student) {
        studentDAO.saveOrUpdate(student);
        return false;
    }

    @Override
    public void delete(Integer id) {
        studentDAO.delete(id);
    }

    @Override
    public Student findById(Integer id) {
        return studentDAO.findById(id);
    }
}
