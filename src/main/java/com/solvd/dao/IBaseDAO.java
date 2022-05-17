package com.solvd.dao;

import java.sql.SQLException;

public interface IBaseDAO<K> {

    void save(K k) throws SQLException;

    void findById(int id) throws SQLException;
}
