package com.solvd.dataBase.dao;

import com.solvd.dataBase.models.Masters;

import java.util.List;

public interface IMasterDAO extends IBaseDAO<Masters> {
    List<Masters> getAllMasters();
}
