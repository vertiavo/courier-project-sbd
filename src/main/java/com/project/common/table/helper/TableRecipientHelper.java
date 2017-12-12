package com.project.common.table.helper;

import com.project.dao.RecipientDao;
import com.project.dao.jpa.RecipientJpaDao;
import com.project.dto.Recipient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class TableRecipientHelper implements TableHelper<Recipient> {

    private final ObservableList<Recipient> data;
    private TableView<Recipient> recipientTable;
    private RecipientDao recipientDao = new RecipientJpaDao();

    public TableRecipientHelper(TableView recipientTable) {
        this.recipientTable = recipientTable;
        this.data = loadData();
        setUp();
    }

    private ObservableList<Recipient> loadData() {
        return FXCollections.observableArrayList(recipientDao.getAll());
    }

    private void setUp() {
        recipientTable.getColumns().clear();
        recipientTable.setEditable(true);

        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<Recipient, Integer>("idRecipient"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<Recipient, String>("name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Recipient, String>>) t -> {
                    Recipient recipient = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    recipient.setName(t.getNewValue());
                    edit(recipient);
                }
        );

        TableColumn surnameCol = new TableColumn("Surname");
        surnameCol.setMinWidth(100);
        surnameCol.setCellValueFactory(new PropertyValueFactory<Recipient, String>("surname"));
        surnameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        surnameCol.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Recipient, String>>) t -> {
                    Recipient recipient = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    recipient.setSurname(t.getNewValue());
                    edit(recipient);
                }
        );

        TableColumn addressCol = new TableColumn("Address");
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(new PropertyValueFactory<Recipient, String>("address"));
        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        addressCol.setOnEditCommit(
                (EventHandler<TableColumn.CellEditEvent<Recipient, String>>) t -> {
                    Recipient recipient = t.getTableView().getItems().get(t.getTablePosition().getRow());
                    recipient.setAddress(t.getNewValue());
                    edit(recipient);
                }
        );

        TableColumn phoneNumberCol = new TableColumn("Phone number");
        phoneNumberCol.setMinWidth(100);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Recipient, Integer>("phoneNumber"));
        // TODO phoneNumber edit handler

        recipientTable.setItems(data);
        recipientTable.getColumns().addAll(idCol, nameCol, surnameCol, addressCol, phoneNumberCol);
    }

    public void add(Recipient recipient) {
        recipientDao.save(recipient);
        data.add(recipient);
    }

    private void edit(Recipient recipient) {
        recipientDao.update(recipient);
    }

    public void delete(Recipient recipient) {
        recipientDao.delete(recipient);
        data.remove(recipient);
    }

}
