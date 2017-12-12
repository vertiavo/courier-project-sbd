package com.project.common;

import com.project.common.table.helper.TableAreaHelper;
import com.project.common.table.helper.TableCarHelper;
import com.project.common.table.helper.TableCourierCarAreaHelper;
import com.project.common.table.helper.TableCourierHelper;
import com.project.common.table.helper.TableHelper;
import com.project.common.table.helper.TableOfferHelper;
import com.project.common.table.helper.TableOrderInfoHelper;
import com.project.common.table.helper.TablePackageDimensionHelper;
import com.project.common.table.helper.TablePackageInfoHelper;
import com.project.common.table.helper.TablePaymentHelper;
import com.project.common.table.helper.TableRecipientHelper;
import com.project.common.table.helper.TableSenderHelper;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private TableView table;

    @FXML
    private ListView<String> listView;

    @FXML
    private Button deleteButton;

    @FXML
    private Button newButton;

    private TableHelper helper;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setListItems();
        setListClickEvent();
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
                    helper = new TableAreaHelper(table);
                    break;
                case CAR:
                    helper = new TableCarHelper(table);
                    break;
                case COURIER:
                    helper = new TableCourierHelper(table);
                    break;
                case COURIER_CAR_AREA:
                    helper = new TableCourierCarAreaHelper(table);
                    break;
                case OFFER:
                    helper = new TableOfferHelper(table);
                    break;
                case ORDER_INFO:
                    helper = new TableOrderInfoHelper(table);
                    break;
                case PACKAGE_DIMENSION:
                    helper = new TablePackageDimensionHelper(table);
                    break;
                case PACKAGE_INFO:
                    helper = new TablePackageInfoHelper(table);
                    break;
                case PAYMENT:
                    helper = new TablePaymentHelper(table);
                    break;
                case RECIPIENT:
                    helper = new TableRecipientHelper(table);
                    break;
                case SENDER:
                    helper = new TableSenderHelper(table);
                    break;
                default:
                    break;
            }
        });
    }

}