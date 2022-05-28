package com.solvd.serviceStation.dao;

import com.solvd.parser.models.ActiveTasks;

import java.util.List;

public interface IActiveTaskDAO {
    List<ActiveTasks> getAllActiveTasks();
}
