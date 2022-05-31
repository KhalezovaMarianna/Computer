package com.solvd.serviceStation.dao;

import com.solvd.serviceStation.classes.Diagnosts;

public interface IDiagnostDAO extends IBaseDAO<Diagnosts> {
    void getAllDiagnosts();
}
