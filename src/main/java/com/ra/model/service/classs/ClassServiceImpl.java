package com.ra.model.service.classs;

import com.ra.model.dao.classs.ClassDAO;
import com.ra.model.entity.Classs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassServiceImpl implements ClassService{
    @Autowired
    private ClassDAO classDAO;

    @Override
    public List<Classs> findAll() {
        return classDAO.findAll();
    }

    @Override
    public boolean saveOrUpdate(Classs classs) {
        classDAO.saveOrUpdate(classs);
        return false;
    }

    @Override
    public void delete(Integer id) {
        classDAO.delete(id);
    }

    @Override
    public Classs findById(Integer id) {
        return classDAO.findById(id);
    }
}
