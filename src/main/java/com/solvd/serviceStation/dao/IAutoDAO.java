package com.solvd.serviceStation.dao;

import com.solvd.serviceStation.classes.Autos;

public interface IAutoDAO extends IBaseDAO<Autos> {
    void getAllAutos();
}
