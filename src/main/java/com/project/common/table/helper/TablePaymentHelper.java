package com.project.common.table.helper;

import com.project.dao.PaymentDao;
import com.project.dao.jpa.PaymentJpaDao;
import com.project.dto.Payment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TablePaymentHelper {

    private final ObservableList<Payment> data;
    private TableView<Payment> paymentTable;
    private PaymentDao paymentDao = new PaymentJpaDao();

    public TablePaymentHelper(TableView paymentTable) {
        this.paymentTable = paymentTable;
        this.data = loadPaymentData();
        setUp();
    }

    private ObservableList<Payment> loadPaymentData() {
        return FXCollections.observableArrayList(paymentDao.getAll());
    }

    private void setUp() {
        paymentTable.getColumns().clear();
        paymentTable.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<Payment, Integer>("idPayment"));

        TableColumn priceCol = new TableColumn("Price");
        priceCol.setMinWidth(50);
        priceCol.setCellValueFactory(new PropertyValueFactory<Payment, Double>("price"));

        TableColumn typeCol = new TableColumn("Type");
        typeCol.setMinWidth(100);
        typeCol.setCellValueFactory(new PropertyValueFactory<Payment, String>("type"));

        paymentTable.setItems(data);
        paymentTable.getColumns().addAll(idCol, priceCol, typeCol);
    }

    public void addPayment(Payment payment) {
        paymentDao.save(payment);
        data.add(payment);
    }

    public void deletePayment(Payment payment) {
        paymentDao.delete(payment);
        data.remove(payment);
    }

}
