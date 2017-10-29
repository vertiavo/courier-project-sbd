package com.project.dao;

public interface GenericDao<T, K> {

    void save(T t);
    void delete(T t);
    void update(T t);
    T findById(K k);

}
