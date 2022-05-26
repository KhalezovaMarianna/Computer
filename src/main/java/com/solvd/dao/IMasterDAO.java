package com.solvd.dao;

import com.solvd.classes.Garages;
import com.solvd.classes.Masters;

import java.util.List;

public interface IMasterDAO extends IBaseDAO<Masters>{
    List<Masters> getAllMasters();
}
