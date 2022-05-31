package com.solvd.dataBase.dao;

import java.sql.SQLException;

public interface IBaseDAO<T> {
T getEntityById(int id) throws SQLException;
    void saveEntity(T entity);
    void updateEntity(T entity);
    void removeEntity(T entity) throws SQLException;

}
