package com.project.common.table.helper;

import com.project.dao.OfferDao;
import com.project.dao.jpa.OfferJpaDao;
import com.project.dto.Courier;
import com.project.dto.Offer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.NumberStringConverter;

public class TableOfferHelper implements TableHelper<Offer> {

    private final ObservableList<Offer> data;
    private TableView<Offer> offerTable;
    private OfferDao offerDao = new OfferJpaDao();

    public TableOfferHelper(TableView offerTable) {
        this.offerTable = offerTable;
        this.data = loadData();
        setUp();
    }

    private ObservableList<Offer> loadData() {
        return FXCollections.observableArrayList(offerDao.getAll());
    }

    private void setUp() {
        offerTable.getColumns().clear();
        offerTable.setEditable(true);

        TableColumn offerTypeCol = new TableColumn("Type");
        offerTypeCol.setMinWidth(50);
        offerTypeCol.setCellValueFactory(new PropertyValueFactory<Offer, String>("offerType"));

        TableColumn discountCol = new TableColumn("Discount");
        discountCol.setMinWidth(50);
        discountCol.setCellValueFactory(new PropertyValueFactory<Offer, Integer>("discount"));
        discountCol.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        discountCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<Offer, Integer>>) t -> {
            Offer offer = t.getTableView().getItems().get(t.getTablePosition().getRow());
            offer.setDiscount(t.getNewValue());
            edit(offer);
        });
        offerTable.setItems(data);
        offerTable.getColumns().addAll(offerTypeCol, discountCol);
    }

    public void add(Offer offer) {
        offerDao.save(offer);
        data.add(offer);
    }

    private void edit(Offer offer) {
        offerDao.update(offer);
    }

    public void delete(Offer offer) {
        offerDao.delete(offer);
        data.remove(offer);
    }

}
