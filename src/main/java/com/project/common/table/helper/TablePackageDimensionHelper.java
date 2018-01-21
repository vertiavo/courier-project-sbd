package com.project.common.table.helper;

import com.project.dao.PackageDimensionDao;
import com.project.dao.jpa.PackageDimensionJpaDao;
import com.project.dto.PackageDimension;

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
public class TablePackageDimensionHelper implements TableHelper<PackageDimension> {

    private final ObservableList<PackageDimension> data;
    private TableView<PackageDimension> packageDimensionTable;
    private PackageDimensionDao packageDimensionDao = new PackageDimensionJpaDao();

    public TablePackageDimensionHelper(TableView packageDimensionTable) {
        this.packageDimensionTable = packageDimensionTable;
        this.data = loadData();
        setUp();
    }

    private ObservableList<PackageDimension> loadData() {
        return FXCollections.observableArrayList(packageDimensionDao.getAll());
    }

    private void setUp() {
        packageDimensionTable.getColumns().clear();
        packageDimensionTable.setEditable(true);

        TableColumn categoryCol = new TableColumn("Category");
        categoryCol.setMinWidth(100);
        categoryCol.setCellValueFactory(new PropertyValueFactory<PackageDimension, String>("category"));

        TableColumn maxWeightCol = new TableColumn("Max weight");
        maxWeightCol.setMinWidth(50);
        maxWeightCol.setCellValueFactory(new PropertyValueFactory<PackageDimension, Double>("maxWeight"));
        maxWeightCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        maxWeightCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<PackageDimension, Double>>) t -> {
            PackageDimension packageDimension = t.getTableView().getItems().get(t.getTablePosition().getRow());
            packageDimension.setMaxWeight(t.getNewValue());
            edit(packageDimension);
        });

        TableColumn maxVolumeCol = new TableColumn("Max volume");
        maxVolumeCol.setMinWidth(50);
        maxVolumeCol.setCellValueFactory(new PropertyValueFactory<PackageDimension, Double>("maxVolume"));
        maxVolumeCol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        maxVolumeCol.setOnEditCommit((EventHandler<TableColumn.CellEditEvent<PackageDimension, Double>>) t -> {
            PackageDimension packageDimension = t.getTableView().getItems().get(t.getTablePosition().getRow());
            packageDimension.setMaxVolume(t.getNewValue());
            edit(packageDimension);
        });
        packageDimensionTable.setItems(data);
        packageDimensionTable.getColumns().addAll(categoryCol, maxWeightCol, maxVolumeCol);
    }

    @Override
    public void add(PackageDimension packageDimension) {
        packageDimensionDao.save(packageDimension);
        data.add(packageDimension);
    }

    @Override
    public void add(List<String> items) {
        PackageDimension packageDimension = new PackageDimension(
                items.get(0),
                Double.valueOf(items.get(1)),
                Double.valueOf(items.get(2)));
        packageDimensionDao.save(packageDimension);
        data.add(packageDimension);
    }

    private void edit(PackageDimension packageDimension) {
        packageDimensionDao.update(packageDimension);
    }

    @Override
    public void delete(PackageDimension packageDimension) {
        packageDimensionDao.delete(packageDimension);
        data.remove(packageDimension);
    }

    @Override
    public void delete(String pk) {
        PackageDimension packageDimension=packageDimensionDao.findById(pk);
        packageDimensionDao.delete(packageDimension);
        data.remove(packageDimension);
    }

    @Override
    public TableView getTable() {
        return packageDimensionTable;
    }

}
