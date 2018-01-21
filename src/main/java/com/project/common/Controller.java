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

import com.project.common.util.FormDialog;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    private List<String> fields;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fields = new ArrayList<>();

        newButton.setVisible(false);
        deleteButton.setVisible(false);

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
                    fields.clear();
                    fields.addAll(Arrays.asList("Name"));
                    break;
                case CAR:
                    helper = new TableCarHelper(table);
                    fields.clear();
                    fields.addAll(Arrays.asList("Brand", "Model", "Load", "Capacity"));
                    break;
                case COURIER:
                    helper = new TableCourierHelper(table);
                    fields.clear();
                    fields.addAll(Arrays.asList("Name", "Surname", "Address", "Phone number"));
                    break;
                case COURIER_CAR_AREA:
                    helper = new TableCourierCarAreaHelper(table);
                    fields.clear();
                    fields.addAll(Arrays.asList("Courier ID", "Car ID", "Area ID", "Begin date", "End date"));
                    break;
                case OFFER:
                    helper = new TableOfferHelper(table);
                    fields.clear();
                    fields.addAll(Arrays.asList("Type", "Discount"));
                    break;
                case ORDER_INFO:
                    helper = new TableOrderInfoHelper(table);
                    fields.clear();
                    fields.addAll(Arrays.asList("Sender", "Recipient", "Courier", "Package", "Payment"));
                    break;
                case PACKAGE_DIMENSION:
                    helper = new TablePackageDimensionHelper(table);
                    fields.clear();
                    fields.addAll(Arrays.asList("Category", "Max weight", "Max Volume"));
                    break;
                case PACKAGE_INFO:
                    helper = new TablePackageInfoHelper(table);
                    fields.clear();
                    fields.addAll(Arrays.asList("Vulnerability", "Category"));
                    break;
                case PAYMENT:
                    helper = new TablePaymentHelper(table);
                    fields.clear();
                    fields.addAll(Arrays.asList("Price", "Type"));
                    break;
                case RECIPIENT:
                    helper = new TableRecipientHelper(table);
                    fields.clear();
                    fields.addAll(Arrays.asList("Name", "Surname", "Address", "Phone number"));
                    break;
                case SENDER:
                    helper = new TableSenderHelper(table);
                    fields.clear();
                    fields.addAll(Arrays.asList("Name", "Surname", "Address", "Offer type", "NIP"));
                    break;
                default:
                    break;
            }
            if (!newButton.isVisible()) {
                newButton.setVisible(true);
                deleteButton.setVisible(true);
                setNewButtonClickEvent();
                setDeletButtonClickEvent();
            }
        });
    }

    private void setDeletButtonClickEvent() {
       deleteButton.setOnAction(a->{
         String pk=  helper.getTable().getSelectionModel().getSelectedItem().toString();
         helper.delete(pk);
       });
    }

    private void setNewButtonClickEvent() {
        List<String> inputValues = fields;
        newButton.setOnAction(e -> {
            FormDialog fd=new FormDialog();
            List<String>params=fd.display(inputValues);

            if (!params.isEmpty()) {
                helper.add(params);
            }
        });
    }

}