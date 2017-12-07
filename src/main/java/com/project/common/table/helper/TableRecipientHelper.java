package com.project.common.table.helper;

import com.project.dao.RecipientDao;
import com.project.dao.jpa.RecipientJpaDao;
import com.project.dto.Recipient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableRecipientHelper {

    private final ObservableList<Recipient> data;
    private TableView<Recipient> recipientTable;
    private RecipientDao recipientDao = new RecipientJpaDao();

    public TableRecipientHelper(TableView recipientTable) {
        this.recipientTable = recipientTable;
        this.data = loadRecipientData();
        setUp();
    }

    private ObservableList<Recipient> loadRecipientData() {
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

        TableColumn surnameCol = new TableColumn("Surname");
        surnameCol.setMinWidth(100);
        surnameCol.setCellValueFactory(new PropertyValueFactory<Recipient, String>("surname"));

        TableColumn addressCol = new TableColumn("Address");
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(new PropertyValueFactory<Recipient, String>("address"));

        TableColumn phoneNumberCol = new TableColumn("Phone number");
        phoneNumberCol.setMinWidth(100);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Recipient, Integer>("phoneNumber"));

        recipientTable.setItems(data);
        recipientTable.getColumns().addAll(idCol, nameCol, surnameCol, addressCol, phoneNumberCol);
    }

    public void addRecipient(Recipient recipient) {
        recipientDao.save(recipient);
        data.add(recipient);
    }

    public void deleteRecipient(Recipient recipient) {
        recipientDao.delete(recipient);
        data.remove(recipient);
    }

}
