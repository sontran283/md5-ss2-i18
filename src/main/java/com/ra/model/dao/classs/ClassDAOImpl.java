package com.ra.model.dao.classs;

import com.ra.model.entity.Classs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassDAOImpl implements ClassDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Classs> findAll() {
        List<Classs> classses = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            classses = session.createQuery("from Classs").list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return classses;
    }

    @Override
    public void saveOrUpdate(Classs classs) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(classs);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Classs findById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            Classs classs = session.get(Classs.class, id);
            return classs;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
