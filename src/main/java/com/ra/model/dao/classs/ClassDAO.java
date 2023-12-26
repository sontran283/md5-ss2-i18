package com.ra.model.dao.classs;

import com.ra.model.entity.Classs;

import java.util.List;

public interface ClassDAO {
    List<Classs> findAll();

    void saveOrUpdate(Classs classs);

    void delete(Integer id);

    Classs findById(Integer id);
}
