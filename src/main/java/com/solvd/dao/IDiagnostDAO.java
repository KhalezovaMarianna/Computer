package com.solvd.dao;

import com.solvd.classes.Diagnosts;
import com.solvd.classes.Masters;

import java.util.List;

public interface IDiagnostDAO extends IBaseDAO<Diagnosts>{
    List<Diagnosts> getAllDiagnosts();
}
