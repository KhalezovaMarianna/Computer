package com.solvd.dao;

import com.solvd.classes.Garages;

import java.sql.SQLException;

public interface IGarageDAO extends IBaseDAO<Garages> {

    void save(Garages garages) throws SQLException;

    void findById(int id) throws SQLException;
}
