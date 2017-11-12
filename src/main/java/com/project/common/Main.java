package com.project.common;

import com.project.dao.AreaDao;
import com.project.dao.CarDao;
import com.project.dao.CourierCarAreaDao;
import com.project.dao.CourierDao;
import com.project.dao.OfferDao;
import com.project.dao.SenderDao;
import com.project.dao.jpa.AreaJpaDao;
import com.project.dao.jpa.CarJpaDao;
import com.project.dao.jpa.CourierCarAreaJpaDao;
import com.project.dao.jpa.CourierJpaDao;
import com.project.dao.jpa.OfferJpaDao;
import com.project.dao.jpa.SenderJpaDao;
import com.project.model.Area;
import com.project.model.Car;
import com.project.model.Courier;
import com.project.model.CourierCarArea;
import com.project.model.CourierCarAreaId;
import com.project.model.Offer;
import com.project.model.Sender;

import java.util.Date;

public class Main {

    public static void main(final String[] args) {

        // Creating APIs for data transfer
        CarDao carDao = new CarJpaDao();
        OfferDao offerDao = new OfferJpaDao();
        SenderDao senderDao = new SenderJpaDao();
        CourierDao courierDao = new CourierJpaDao();
        AreaDao areaDao = new AreaJpaDao();
        CourierCarAreaDao courierCarAreaDao = new CourierCarAreaJpaDao();

//        Car car1 = new Car();
//        car1.setBrand("Fiat");
//        car1.setModel("Multipla");
//        car1.setLoad(50d);
//        car1.setCapacity(15d);
//        carDao.save(car1);

        Car car2 = new Car();
        car2.setBrand("Nissan");
        car2.setModel("Almera");
        car2.setLoad(30d);
        car2.setCapacity(20d);
        carDao.save(car2);

//        Offer offer1 = new Offer("STANDARD", 0);
//        offerDao.save(offer1);

//        Sender sender1 = new Sender();
//        sender1.setName("Zbigniew");
//        sender1.setSurname("Dwunoga");
//        sender1.setAddress("Wiejska");
//        sender1.setOfferType(offerDao.findById("STANDARD"));
//        senderDao.save(sender1);

//        Area area1 = new Area("BOJARY");
//        areaDao.save(area1);
//
//        Courier courier1 = new Courier("Jan", "Kowalski", "Piastowska", 123456789);
//        courierDao.save(courier1);
//
//        CourierCarArea courierCarArea1 = new CourierCarArea();
//        // Setting primary key with embeddable class (PKs is courier and begin date)
//        courierCarArea1.setIdCourierCarArea(new CourierCarAreaId(courier1, new Date()));
//        courierCarArea1.setIdCar(carDao.findById(1));
//        courierCarArea1.setIdArea(area1);
//        courierCarArea1.setEndDate(new Date());
//        courierCarAreaDao.save(courierCarArea1);

    }
}