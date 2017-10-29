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
            session.persist(t);
        }
    }

    @Override
    public void delete(T t) {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        try (Session session = sf.openSession()) {
            t = (T) session.merge(t);
            session.remove(t);
        }
    }

    @Override
    public void update(T t) {
        SessionFactory sf = HibernateUtil.getSessionFactory();

        try (Session session = sf.openSession()) {
            session.merge(t);
        }
    }

    @Override
    public T findById(K k) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        T model = null;

        try (Session session = sf.openSession()) {
            model = session.find(type, k);
        }
        return model;
    }
}
