package com.project.common;

import com.project.dao.CarDao;
import com.project.dao.OfferDao;
import com.project.dao.SenderDao;
import com.project.dao.jpa.CarJpaDao;
import com.project.dao.jpa.OfferJpaDao;
import com.project.dao.jpa.SenderJpaDao;
import com.project.model.Car;
import com.project.model.Offer;
import com.project.model.Sender;

public class Main {

    public static void main(final String[] args) throws Exception {

        CarDao carDao = new CarJpaDao();
        Car car1 = new Car();
        car1.setBrand("Fiat");
        car1.setModel("Multipla");
        car1.setLoad(50d);
        car1.setCapacity(15d);
        carDao.save(car1);

        OfferDao offerDao = new OfferJpaDao();
        Offer offer1 = new Offer("STANDARD", 0);
        offerDao.save(offer1);

        SenderDao senderDao = new SenderJpaDao();
        Sender sender1 = new Sender();
        sender1.setName("Zbigniew");
        sender1.setSurname("Dwunoga");
        sender1.setAddress("Wiejska");
        sender1.setOfferType(offerDao.findById("STANDARD"));
        senderDao.save(sender1);

    }
}