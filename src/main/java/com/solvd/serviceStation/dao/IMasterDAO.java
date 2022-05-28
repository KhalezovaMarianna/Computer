package com.solvd.serviceStation.dao;

import com.solvd.serviceStation.classes.Masters;

import java.util.List;

public interface IMasterDAO extends IBaseDAO<Masters> {
    List<Masters> getAllMasters();
}
