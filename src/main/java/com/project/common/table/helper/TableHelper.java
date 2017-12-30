package com.project.common.table.helper;

import java.util.List;

public interface TableHelper<T> {

    void add(T item);
    void add(List<String> items);
    void delete(T item);

}
