package com.solvd.serviceStation.dao;

import com.solvd.serviceStation.classes.Autos;

import java.util.List;

public interface IAutoDAO extends IBaseDAO<Autos> {
    List<Autos> getAllAutos();
}
