package com.project.common.util;

import com.project.dao.*;
import com.project.dao.jpa.*;
import com.project.dto.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FormDialog {
    private static List<String> listOfEntitiesNames;

    public FormDialog() {
    }

    public List<String> display(List<String> fields) {
        LinkedList<String> params = new LinkedList<>();
        initEntitiesName();

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("New ");
        window.setMinWidth(300);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        window.setScene(scene);

        List<TextField> textFields = new ArrayList<>();

        int rowNum = 1;
        for (String field : fields) {
            Label label = new Label(field);
            grid.add(label, 0, rowNum);
            if (checkIfFieldIsDatePicker(field)) {
                DatePicker dp = new DatePicker();
                grid.add(dp, 1, rowNum);
            } else if (checkIfFieldIsEntity(field)) {
                ComboBox<ComboBoxProp> cb = new ComboBox<>();
                cb = populateComboBox(cb, field);
                grid.add(cb, 1, rowNum);
            } else {
                TextField textField = new TextField();
                grid.add(textField, 1, rowNum);
                textFields.add(textField);
            }
            ;
            rowNum++;
        }

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            fields.clear();
            // textFields.forEach(field -> fields.add(field.getText()));
            int rows = getRowCount(grid);
            for (int i = 0; i < rows; i++) {
                Node n = getNodeFromGridPane(grid, 1, i);
                if (n instanceof TextField) {
                    params.add(((TextField) n).getText().toString());
                } else if (n instanceof ComboBox) {
                    ComboBoxProp comboBoxProp = (ComboBoxProp) ((ComboBox) n).getValue();
                    if (comboBoxProp instanceof ComboBoxPropWithoutId) {
                        params.add(comboBoxProp.getInfo());
                    } else {
                        if (comboBoxProp.getId() == -1) {
                            params.add(String.valueOf(comboBoxProp.getInfo()));
                        } else {
                            params.add(String.valueOf(comboBoxProp.getId()));
                        }
                    }


                } else if (n instanceof DatePicker) {
                    params.add(((DatePicker) n).getValue().toString());
                }
            }
            window.close();
        });

        Button cancelButton = new Button("Close");
        cancelButton.setOnAction(e -> {
            fields.clear();
            window.close();
        });

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().addAll(addButton, cancelButton);
        grid.add(hBox, 1, rowNum);
        window.showAndWait();
        return params;
    }

    private boolean checkIfFieldIsDatePicker(String field) {
        return field.equals("Begin date") || field.equals("End date") || field.equals("Order Date");
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    private ComboBox<ComboBoxProp> populateComboBox(ComboBox<ComboBoxProp> cb, String field) {
        switch (field) {
            case "Area ID":
                AreaDao areaDao = new AreaJpaDao();
                List<Area> areaList = areaDao.getAll();
                ObservableList<ComboBoxProp> areaOl = FXCollections.observableArrayList();
                areaList.stream().forEach(a -> areaOl.addAll(new ComboBoxProp(a.getIdArea(), a.getName())));
                cb.setItems(areaOl);
                break;

            case "Car ID":
                CarDao carDao = new CarJpaDao();
                List<Car> carList = carDao.getAll();
                ObservableList<ComboBoxProp> carOL = FXCollections.observableArrayList();
                carList.stream().forEach(c -> carOL.add(new ComboBoxProp(c.getIdCar(), c.getModel())));
                cb.setItems(carOL);
                break;

            case "Courier ID":
            case "Courier":
                CourierDao courierDao = new CourierJpaDao();
                List<Courier> courierList = courierDao.getAll();
                ObservableList<ComboBoxProp> courierOL = FXCollections.observableArrayList();
                courierList.stream().forEach(c -> courierOL.add(new ComboBoxProp(c.getIdCourier(), c.getSurname())));
                cb.setItems(courierOL);
                break;
            case "Offer type":
                OfferDao offerDao = new OfferJpaDao();
                List<Offer> offerList = offerDao.getAll();
                ObservableList<ComboBoxProp> offerOL = FXCollections.observableArrayList();
                offerList.stream().forEach(a -> offerOL.add(new ComboBoxProp(-1, a.getOfferType())));
                cb.setItems(offerOL);
                break;
            case "Package":
                PackageInfoDao packageInfoDao = new PackageInfoJpaDao();
                List<PackageInfo> packageList = packageInfoDao.getAll();
                ObservableList<ComboBoxProp> packageOL = FXCollections.observableArrayList();
                packageList.stream()
                           .forEach(p -> packageOL.add(new ComboBoxProp(p.getIdPackage(), p.getVulnerability())));
                cb.setItems(packageOL);
                break;
            case "Payment":
                PaymentDao paymentDao = new PaymentJpaDao();
                List<Payment> paymentList = paymentDao.getAll();
                ObservableList<ComboBoxProp> paymentOL = FXCollections.observableArrayList();
                paymentList.stream().forEach(p -> paymentOL.add(new ComboBoxProp(p.getIdPayment(), p.getType())));
                cb.setItems(paymentOL);
                break;
            case "Category":
                PackageDimensionDao packageDimensionDao = new PackageDimensionJpaDao();
                List<PackageDimension> packageDimensionList = packageDimensionDao.getAll();
                ObservableList<ComboBoxProp> packageDimensionOL = FXCollections.observableArrayList();
                packageDimensionList.forEach(packageDimension -> packageDimensionOL
                        .add(new ComboBoxPropWithoutId(packageDimension.getCategory())));
                cb.setItems(packageDimensionOL);
                break;
            case "Recipient":
                RecipientDao recipientDao = new RecipientJpaDao();
                List<Recipient> recipientList = recipientDao.getAll();
                ObservableList<ComboBoxProp> recipientOL = FXCollections.observableArrayList();
                recipientList.stream()
                             .forEach(r -> recipientOL.add(new ComboBoxProp(r.getIdRecipient(), r.getSurname())));
                cb.setItems(recipientOL);
                break;
            case "Sender":
                SenderDao senderDao = new SenderJpaDao();
                List<Sender> senderList = senderDao.getAll();
                ObservableList<ComboBoxProp> senderOL = FXCollections.observableArrayList();
                senderList.stream().forEach(c -> senderOL.add(new ComboBoxProp(c.getIdSender(), c.getSurname())));
                cb.setItems(senderOL);
                break;
        }

        cb.setConverter(new StringConverter<ComboBoxProp>() {

            @Override
            public String toString(ComboBoxProp object) {
                if (object instanceof ComboBoxPropWithoutId) return object.getInfo();
                return "Id:" + object.getId() + ",value: " + object.getInfo();
            }

            @Override
            public ComboBoxProp fromString(String string) {
                return cb.getItems().stream().filter(ap -> ap.getInfo().equals(string)).findFirst().orElse(null);
            }
        });
        return cb;
    }

    private static void initEntitiesName() {
        listOfEntitiesNames = new ArrayList<String>();
        listOfEntitiesNames.add("Courier");
        listOfEntitiesNames.add("Offer type");
        listOfEntitiesNames.add("Payment");
        listOfEntitiesNames.add("Recipient");
        listOfEntitiesNames.add("Sender");
        listOfEntitiesNames.add("Car ID");
        listOfEntitiesNames.add("Courier ID");
        listOfEntitiesNames.add("Area ID");
        listOfEntitiesNames.add("Package");
        listOfEntitiesNames.add("Category");

    }

    private static boolean checkIfFieldIsEntity(String field) {
        return listOfEntitiesNames.stream().anyMatch(str -> str.trim().equals(field));
    }

    private class ComboBoxProp {
        private int id;
        private String info;

        public ComboBoxProp(int id, String info) {
            this.id = id;
            this.info = info;
        }

        public int getId() {
            return id;
        }

        public String getInfo() {
            return info;
        }
    }

    private class ComboBoxPropWithoutId extends ComboBoxProp {

        public ComboBoxPropWithoutId(String info) {
            super(1, info);
        }
    }

    private int getRowCount(GridPane pane) {
        int numRows = pane.getRowConstraints().size();
        for (int i = 0; i < pane.getChildren().size(); i++) {
            Node child = pane.getChildren().get(i);
            if (child.isManaged()) {
                Integer rowIndex = GridPane.getRowIndex(child);
                if (rowIndex != null) {
                    numRows = Math.max(numRows, rowIndex + 1);
                }
            }
        }
        return numRows;
    }
}
