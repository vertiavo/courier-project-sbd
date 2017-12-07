package com.project.common.table.helper;

import com.project.dao.SenderDao;
import com.project.dao.jpa.SenderJpaDao;
import com.project.dto.Sender;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableSenderHelper {

    private final ObservableList<Sender> data;
    private TableView<Sender> senderTable;
    private SenderDao senderDao = new SenderJpaDao();

    public TableSenderHelper(TableView senderTable) {
        this.senderTable = senderTable;
        this.data = loadSenderData();
        setUp();
    }

    private ObservableList<Sender> loadSenderData() {
        return FXCollections.observableArrayList(senderDao.getAll());
    }

    private void setUp() {
        senderTable.getColumns().clear();
        senderTable.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<Sender, Integer>("idSender"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<Sender, String>("name"));

        TableColumn surnameCol = new TableColumn("Surname");
        surnameCol.setMinWidth(100);
        surnameCol.setCellValueFactory(new PropertyValueFactory<Sender, String>("surname"));

        TableColumn addressCol = new TableColumn("Address");
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(new PropertyValueFactory<Sender, String>("address"));

        TableColumn offerTypeCol = new TableColumn("Offer type");
        offerTypeCol.setMinWidth(100);
        offerTypeCol.setCellValueFactory(new PropertyValueFactory<Sender, String>("offerType"));

        TableColumn nipCol = new TableColumn("NIP");
        nipCol.setMinWidth(50);
        nipCol.setCellValueFactory(new PropertyValueFactory<Sender, Integer>("nip"));

        senderTable.setItems(data);
        senderTable.getColumns().addAll(idCol, nameCol, surnameCol, addressCol, offerTypeCol, nipCol);
    }

    public void addSender(Sender sender) {
        senderDao.save(sender);
        data.add(sender);
    }

    public void deleteSender(Sender sender) {
        senderDao.delete(sender);
        data.remove(sender);
    }

}
