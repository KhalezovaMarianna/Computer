package com.solvd.dataBase.dao;

import com.solvd.dataBase.classes.Masters;

import java.util.List;

public interface IMasterDAO extends IBaseDAO<Masters> {
    List<Masters> getAllMasters();
}
