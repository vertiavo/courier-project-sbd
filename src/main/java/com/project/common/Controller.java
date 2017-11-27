package com.project.common;

import com.project.dao.AreaDao;
import com.project.dao.CarDao;
import com.project.dao.CourierCarAreaDao;
import com.project.dao.CourierDao;
import com.project.dao.OfferDao;
import com.project.dao.OrderInfoDao;
import com.project.dao.PackageDimensionDao;
import com.project.dao.PackageInfoDao;
import com.project.dao.PaymentDao;
import com.project.dao.RecipientDao;
import com.project.dao.SenderDao;
import com.project.dao.jpa.AreaJpaDao;
import com.project.dao.jpa.CarJpaDao;
import com.project.dao.jpa.CourierCarAreaJpaDao;
import com.project.dao.jpa.CourierJpaDao;
import com.project.dao.jpa.OfferJpaDao;
import com.project.dao.jpa.OrderInfoJpaDao;
import com.project.dao.jpa.PackageDimensionJpaDao;
import com.project.dao.jpa.PackageInfoJpaDao;
import com.project.dao.jpa.PaymentJpaDao;
import com.project.dao.jpa.RecipientJpaDao;
import com.project.dao.jpa.SenderJpaDao;
import com.project.model.Car;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static final String AREA = "Area";
    private static final String CAR = "Car";
    private static final String COURIER = "Courier";
    private static final String COURIER_CAR_AREA = "CourierCarArea";
    private static final String OFFER = "Offer";
    private static final String ORDER_INFO = "OrderInfo";
    private static final String PACKAGE_DIMENSION = "PackageDimension";
    private static final String PACKAGE_INFO = "PackageInfo";
    private static final String PAYMENT = "Payment";
    private static final String RECIPIENT = "Recipient";
    private static final String SENDER = "Sender";

    @FXML
    private TableView<Car> table;

    @FXML
    private ListView<String> listView;

    private ObservableList<Car> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        data  =  FXCollections.observableArrayList();

        setListItems();
        setListClickEvent();

        table.setItems(data);
    }

    private void setListItems() {
        listView.setItems(FXCollections.observableArrayList(
                AREA,
                CAR,
                COURIER,
                COURIER_CAR_AREA,
                OFFER,
                ORDER_INFO,
                PACKAGE_DIMENSION,
                PACKAGE_INFO,
                PAYMENT,
                RECIPIENT,
                SENDER
        ));
    }

    private void setListClickEvent() {
        listView.setOnMouseClicked(e -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            switch (selectedItem) {
                case AREA:
                    AreaDao areaDao = new AreaJpaDao();
                    System.out.println(areaDao.getAll());
                    break;
                case CAR:
                    CarDao carDao = new CarJpaDao();
                    System.out.println(carDao.getAll());
                    break;
                case COURIER:
                    CourierDao courierDao = new CourierJpaDao();
                    System.out.println(courierDao.getAll());
                    break;
                case COURIER_CAR_AREA:
                    CourierCarAreaDao courierCarAreaDao = new CourierCarAreaJpaDao();
                    System.out.println(courierCarAreaDao.getAll());
                    break;
                case OFFER:
                    OfferDao offerDao = new OfferJpaDao();
                    System.out.println(offerDao.getAll());
                    break;
                case ORDER_INFO:
                    OrderInfoDao orderInfoDao = new OrderInfoJpaDao();
                    System.out.println(orderInfoDao.getAll());
                    break;
                case PACKAGE_DIMENSION:
                    PackageDimensionDao packageDimensionDao = new PackageDimensionJpaDao();
                    System.out.println(packageDimensionDao.getAll());
                    break;
                case PACKAGE_INFO:
                    PackageInfoDao packageInfoDao = new PackageInfoJpaDao();
                    System.out.println(packageInfoDao.getAll());
                    break;
                case PAYMENT:
                    PaymentDao paymentDao = new PaymentJpaDao();
                    System.out.println(paymentDao.getAll());
                    break;
                case RECIPIENT:
                    RecipientDao recipientDao = new RecipientJpaDao();
                    System.out.println(recipientDao.getAll());
                    break;
                case SENDER:
                    SenderDao senderDao = new SenderJpaDao();
                    System.out.println(senderDao.getAll());
                    break;
            }
        });
    }

}