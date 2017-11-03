package com.project.common;

import com.project.dao.CarDao;
import com.project.dao.jpa.CarJpaDao;
import com.project.model.Car;
import com.project.persistence.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {

    public static void main(final String[] args) throws Exception {

        SessionFactory sf = HibernateUtil.getSessionFactory();

        try (Session session = sf.openSession()) {

            CarDao carDao = new CarJpaDao();
            Car car1 = new Car("Fiat", "Multipla", 50d, 15d);
            carDao.save(car1);

        }
    }
}