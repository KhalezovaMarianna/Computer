package com.solvd.serviceStation.dao;

import com.solvd.serviceStation.classes.Diagnosts;

import java.util.List;

public interface IDiagnostDAO extends IBaseDAO<Diagnosts> {
    List<Diagnosts> getAllDiagnosts();
}
