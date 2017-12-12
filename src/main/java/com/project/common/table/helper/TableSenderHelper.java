package com.project.common.table.helper;

import com.project.dao.SenderDao;
import com.project.dao.jpa.SenderJpaDao;
import com.project.dto.Sender;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class TableSenderHelper implements TableHelper<Sender> {

    private final ObservableList<Sender> data;
    private TableView<Sender> senderTable;
    private SenderDao senderDao = new SenderJpaDao();

    public TableSenderHelper(TableView senderTable) {
        this.senderTable = senderTable;
        this.data = loadData();
        setUp();
    }

    private ObservableList<Sender> loadData() {
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
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Sender, String>>) t -> {
                    Sender sender = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    sender.setName(t.getNewValue());
                    edit(sender);
                }
        );

        TableColumn surnameCol = new TableColumn("Surname");
        surnameCol.setMinWidth(100);
        surnameCol.setCellValueFactory(new PropertyValueFactory<Sender, String>("surname"));
        surnameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        surnameCol.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Sender, String>>) t -> {
                    Sender sender = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    sender.setSurname(t.getNewValue());
                    edit(sender);
                }
        );

        TableColumn addressCol = new TableColumn("Address");
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(new PropertyValueFactory<Sender, String>("address"));
        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        addressCol.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Sender, String>>) t -> {
                    Sender sender = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    sender.setAddress(t.getNewValue());
                    edit(sender);
                }
        );

        TableColumn offerTypeCol = new TableColumn("Offer type");
        offerTypeCol.setMinWidth(100);
        offerTypeCol.setCellValueFactory(new PropertyValueFactory<Sender, String>("offerType"));
        // TODO dropdown for choosing desired offerType

        TableColumn nipCol = new TableColumn("NIP");
        nipCol.setMinWidth(50);
        nipCol.setCellValueFactory(new PropertyValueFactory<Sender, Integer>("nip"));
        // TODO nip edit handler

        senderTable.setItems(data);
        senderTable.getColumns().addAll(idCol, nameCol, surnameCol, addressCol, offerTypeCol, nipCol);
    }

    public void add(Sender sender) {
        senderDao.save(sender);
        data.add(sender);
    }

    private void edit(Sender sender) {
        senderDao.update(sender);
    }

    public void delete(Sender sender) {
        senderDao.delete(sender);
        data.remove(sender);
    }

}
