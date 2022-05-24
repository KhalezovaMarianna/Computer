package com.solvd.dao;

import com.solvd.classes.Garages;

import java.sql.SQLException;
import java.util.List;

public interface IGarageDAO extends IBaseDAO<Garages> {

   List<Garages> getAllGarages();
}
