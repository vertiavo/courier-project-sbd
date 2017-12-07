package com.project.common.table.helper;

import com.project.dao.OfferDao;
import com.project.dao.jpa.OfferJpaDao;
import com.project.dto.Offer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableOfferHelper {

    private final ObservableList<Offer> data;
    private TableView<Offer> offerTable;
    private OfferDao offerDao = new OfferJpaDao();

    public TableOfferHelper(TableView offerTable) {
        this.offerTable = offerTable;
        this.data = loadOfferData();
        setUp();
    }

    private ObservableList<Offer> loadOfferData() {
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

        offerTable.setItems(data);
        offerTable.getColumns().addAll(offerTypeCol, discountCol);
    }

    public void addOffer(Offer offer) {
        offerDao.save(offer);
        data.add(offer);
    }

    public void deleteOffer(Offer offer) {
        offerDao.delete(offer);
        data.remove(offer);
    }

}
