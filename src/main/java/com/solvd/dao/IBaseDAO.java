package com.solvd.dao;

import java.sql.SQLException;

public interface IBaseDAO<T> {
T getEntityById(int id) throws SQLException;
    void save(T entity) throws SQLException;
    void createEntity (T entity);
    void updateEntity(T entity);
    void removeEntity(T entity) throws SQLException;
    void findById(int id) throws SQLException;
}
