package com.solvd.serviceStation.dao;

import com.solvd.serviceStation.classes.TimeToWork;

import java.util.List;

public interface ITimeToWorkDAO extends IBaseDAO<TimeToWork> {
    List<TimeToWork> getAllTimeToWork();
}
