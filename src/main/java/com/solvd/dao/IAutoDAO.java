package com.solvd.dao;

import com.solvd.classes.Autos;
import com.solvd.classes.Masters;

import java.util.List;

public interface IAutoDAO extends IBaseDAO<Autos>{
    List<Autos> getAllAutos();
}
