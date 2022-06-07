package com.solvd.dataBase.dao;

import com.solvd.dataBase.models.TimeToWork;

import java.util.List;

public interface ITimeToWorkDAO extends IBaseDAO<TimeToWork> {
    List<TimeToWork> getAllTimeToWork();
}
