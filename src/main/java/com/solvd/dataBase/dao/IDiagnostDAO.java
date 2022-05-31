package com.solvd.dataBase.dao;

import com.solvd.dataBase.classes.Diagnosts;

public interface IDiagnostDAO extends IBaseDAO<Diagnosts> {
    void getAllDiagnosts();
}
