package com.project.dao.jpa;

import com.project.dao.GenericDao;
import com.project.persistence.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
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
        }
    }

    @Override
    public T findById(K k) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        T model;

        try (Session session = sf.openSession()) {
            model = session.find(type, k);
        }
        return model;
    }

    @Override
    public List<T> getAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        List<T> data = new ArrayList<>();

        try (Session session = sf.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
            Root<T> genericData = criteriaQuery.from(type);
            criteriaQuery.select(genericData);

            TypedQuery<T> typedQuery = session.createQuery(criteriaQuery);
            data = typedQuery.getResultList();
        }

        return data;
    }
}
