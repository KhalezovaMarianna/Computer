package com.solvd.dao;

import com.solvd.classes.TimeToWork;

import java.util.List;

public interface ITimeToWorkDAO extends IBaseDAO<TimeToWork> {
    List<TimeToWork> getAllTimeToWork();
}
