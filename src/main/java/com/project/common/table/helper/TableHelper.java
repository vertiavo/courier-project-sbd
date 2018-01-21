package com.project.common.table.helper;

import javafx.scene.control.TableView;

import java.util.List;

public interface TableHelper<T> {

    void add(T item);
    void add(List<String> items);
    void delete(T item);
    void delete(String pk);
    TableView getTable();

}
