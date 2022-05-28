package com.solvd.serviceStation.dao;

import com.solvd.serviceStation.classes.Garages;

import java.util.List;

public interface IGarageDAO extends IBaseDAO<Garages> {

   List<Garages> getAllGarages();
}
