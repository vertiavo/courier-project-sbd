package com.project.common.table.helper;

import com.project.common.util.AlertDialog;
import com.project.common.util.FieldValidator;
import com.project.dao.PaymentDao;
import com.project.dao.jpa.PaymentJpaDao;
import com.project.dto.Payment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

import java.util.List;

@SuppressWarnings("unchecked")
public class TablePaymentHelper implements TableHelper<Payment> {

    private final ObservableList<Payment> data;
    private TableView<Payment> paymentTable;
    private PaymentDao paymentDao = new PaymentJpaDao();

    public TablePaymentHelper(TableView paymentTable) {
        this.paymentTable = paymentTable;
        this.data = loadData();
        setUp();
    }

    private ObservableList<Payment> loadData() {
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
        priceCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        priceCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<Payment, Double>>) t -> {
            Payment payment = t.getTableView().getItems().get(t.getTablePosition().getRow());
            payment.setPrice(t.getNewValue());
            edit(payment);
        });

        TableColumn typeCol = new TableColumn("Type");
        typeCol.setMinWidth(100);
        typeCol.setCellValueFactory(new PropertyValueFactory<Payment, String>("type"));
        typeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        typeCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<Payment, String>>) t -> {
            if (FieldValidator.validateText(t.getNewValue())) {
                Payment payment = t.getTableView().getItems().get(t.getTablePosition().getRow());
                payment.setType(t.getNewValue().toUpperCase());
                edit(payment);
            } else {
                AlertDialog.display("Error", "Invalid value");
            }
        });

        paymentTable.setItems(data);
        paymentTable.getColumns().addAll(idCol, priceCol, typeCol);
    }

    @Override
    public void add(Payment payment) {
        paymentDao.save(payment);
        data.add(payment);
    }

    @Override
    public void add(List<String> items) {
        Payment payment = new Payment(Double.valueOf(items.get(0)), items.get(0));
        paymentDao.save(payment);
        data.add(payment);
    }

    private void edit(Payment payment) {
        paymentDao.update(payment);
    }

    @Override
    public void delete(Payment payment) {
        paymentDao.delete(payment);
        data.remove(payment);
    }

}
