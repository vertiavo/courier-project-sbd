package com.project.common.table.helper;

import com.project.dao.PackageDimensionDao;
import com.project.dao.jpa.PackageDimensionJpaDao;
import com.project.dto.PackageDimension;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TablePackageDimensionHelper {

    private final ObservableList<PackageDimension> data;
    private TableView<PackageDimension> packageDimensionTable;
    private PackageDimensionDao packageDimensionDao = new PackageDimensionJpaDao();

    public TablePackageDimensionHelper(TableView packageDimensionTable) {
        this.packageDimensionTable = packageDimensionTable;
        this.data = loadPackageDimensionData();
        setUp();
    }

    private ObservableList<PackageDimension> loadPackageDimensionData() {
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

        TableColumn maxVolumeCol = new TableColumn("Max volume");
        maxVolumeCol.setMinWidth(50);
        maxVolumeCol.setCellValueFactory(new PropertyValueFactory<PackageDimension, Double>("maxVolume"));

        packageDimensionTable.setItems(data);
        packageDimensionTable.getColumns().addAll(categoryCol, maxWeightCol, maxVolumeCol);
    }

    public void addPackageDimension(PackageDimension packageDimension) {
        packageDimensionDao.save(packageDimension);
        data.add(packageDimension);
    }

    public void deletePackageDimension(PackageDimension packageDimension) {
        packageDimensionDao.delete(packageDimension);
        data.remove(packageDimension);
    }

}
