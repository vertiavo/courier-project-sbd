package com.project.common.table.helper;

import com.project.dao.OrderInfoDao;
import com.project.dao.jpa.OrderInfoJpaDao;
import com.project.dto.OrderInfo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class TableOrderInfoHelper {

    private final ObservableList<OrderInfo> data;
    private TableView<OrderInfo> orderInfoTable;
    private OrderInfoDao orderInfoDao = new OrderInfoJpaDao();

    public TableOrderInfoHelper(TableView orderInfoTable) {
        this.orderInfoTable = orderInfoTable;
        this.data = loadOrderInfoData();
        setUp();
    }

    private ObservableList<OrderInfo> loadOrderInfoData() {
        return FXCollections.observableArrayList(orderInfoDao.getAll());
    }

    private void setUp() {
        orderInfoTable.getColumns().clear();
        orderInfoTable.setEditable(true);

        TableColumn idOrderCol = new TableColumn("ID");
        idOrderCol.setMinWidth(50);
        idOrderCol.setCellValueFactory(new PropertyValueFactory<OrderInfo, Integer>("idOrder"));

        TableColumn idSenderCol = new TableColumn("Sender ID");
        idSenderCol.setMinWidth(50);
        idSenderCol.setCellValueFactory(new PropertyValueFactory<OrderInfo, String>("idSender"));

        TableColumn idRecipientCol = new TableColumn("Recipient ID");
        idRecipientCol.setMinWidth(50);
        idRecipientCol.setCellValueFactory(new PropertyValueFactory<OrderInfo, String>("idRecipient"));

        TableColumn idCourierCol = new TableColumn("Courier ID");
        idCourierCol.setMinWidth(50);
        idCourierCol.setCellValueFactory(new PropertyValueFactory<OrderInfo, Double>("idCourier"));

        TableColumn idPackageCol = new TableColumn("Package ID");
        idPackageCol.setMinWidth(50);
        idPackageCol.setCellValueFactory(new PropertyValueFactory<OrderInfo, Double>("idPackage"));

        TableColumn idPaymentCol = new TableColumn("Payment ID");
        idPaymentCol.setMinWidth(50);
        idPaymentCol.setCellValueFactory(new PropertyValueFactory<OrderInfo, Double>("idPayment"));

        TableColumn orderDateCol = new TableColumn("Order date");
        orderDateCol.setMinWidth(150);
        orderDateCol.setCellValueFactory(new PropertyValueFactory<OrderInfo, Date>("orderDate"));

        orderInfoTable.setItems(data);
        orderInfoTable.getColumns().addAll(idOrderCol, idSenderCol, idRecipientCol, idCourierCol, idPackageCol, idPaymentCol, orderDateCol);
    }

    public void addOrderInfo(OrderInfo orderInfo) {
        orderInfoDao.save(orderInfo);
        data.add(orderInfo);
    }

    public void deleteOrderInfo(OrderInfo orderInfo) {
        orderInfoDao.delete(orderInfo);
        data.remove(orderInfo);
    }

}
