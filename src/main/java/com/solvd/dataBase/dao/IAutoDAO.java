package com.solvd.dataBase.dao;

import com.solvd.dataBase.models.Autos;

import java.util.List;

public interface IAutoDAO extends IBaseDAO<Autos> {
    List<Autos> getAllAutos();
}
