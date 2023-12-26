package com.ra.model.service.classs;

import com.ra.model.entity.Classs;

import java.util.List;

public interface ClassService {
    List<Classs> findAll();

    boolean saveOrUpdate(Classs classs);

    void delete(Integer id);

    Classs findById(Integer id);
}
