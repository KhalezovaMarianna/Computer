package com.solvd.dataBase.dao;

import com.solvd.dataBase.classes.Autos;

import java.util.List;

public interface IAutoDAO extends IBaseDAO<Autos> {
    List<Autos> getAllAutos();
    Autos getAutos();
}
