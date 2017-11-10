package com.project.dao.jpa;

import com.project.dao.GenericDao;
import com.project.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericJpaDao<T, K> implements GenericDao<T, K> {

    private final Class<T> type;

    public GenericJpaDao() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public void save(T t) {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            System.out.println("Record added.");
        } finally {
            sf.close();
        }
    }

    @Override
    public void delete(T t) {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        try (Session session = sf.openSession()) {
            session.beginTransaction();
            t = (T) session.merge(t);
            session.remove(t);
            session.getTransaction().commit();
            System.out.println("Record removed.");
        } finally {
            sf.close();
        }
    }

    @Override
    public void update(T t) {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.merge(t);
            session.getTransaction().commit();
            System.out.println("Record updated.");
        } finally {
            sf.close();
        }
    }

    @Override
    public T findById(K k) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        T model;

        try (Session session = sf.openSession()) {
            model = session.find(type, k);
        } finally {
            sf.close();
        }
        return model;
    }
}
