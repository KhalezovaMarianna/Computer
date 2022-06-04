package com.solvd.dataBase.dao;

import com.solvd.dataBase.classes.Diagnosts;

import java.util.List;

public interface IDiagnostDAO extends IBaseDAO<Diagnosts> {
    List<Diagnosts> getAllDiagnosts();
}
