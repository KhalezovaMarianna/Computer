package com.solvd.dataBase.dao;

import com.solvd.dataBase.classes.Autos;

public interface IAutoDAO extends IBaseDAO<Autos> {
    void getAllAutos();
}
