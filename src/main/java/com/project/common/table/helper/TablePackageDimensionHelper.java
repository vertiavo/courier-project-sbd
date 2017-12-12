package com.project.common.table.helper;

import com.project.dao.PackageDimensionDao;
import com.project.dao.jpa.PackageDimensionJpaDao;
import com.project.dto.PackageDimension;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        // TODO load edit handler

        TableColumn maxVolumeCol = new TableColumn("Max volume");
        maxVolumeCol.setMinWidth(50);
        maxVolumeCol.setCellValueFactory(new PropertyValueFactory<PackageDimension, Double>("maxVolume"));
        // TODO load edit handler

        packageDimensionTable.setItems(data);
        packageDimensionTable.getColumns().addAll(categoryCol, maxWeightCol, maxVolumeCol);
    }

    public void add(PackageDimension packageDimension) {
        packageDimensionDao.save(packageDimension);
        data.add(packageDimension);
    }

    private void edit(PackageDimension packageDimension) {
        packageDimensionDao.update(packageDimension);
    }

    public void delete(PackageDimension packageDimension) {
        packageDimensionDao.delete(packageDimension);
        data.remove(packageDimension);
    }

}
