package com.solvd.dataBase.dao;

import com.solvd.dataBase.classes.Autos;

import java.util.List;

public interface IAutoDAO extends IBaseDAO<Autos> {
    void getAllAutos();
    List<Autos> getAutos();
}
