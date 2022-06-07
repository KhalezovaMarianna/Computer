package com.solvd.dataBase.dao;

import com.solvd.dataBase.models.Garages;

import java.util.List;

public interface IGarageDAO extends IBaseDAO<Garages> {

   List<Garages> getAllGarages();
}
