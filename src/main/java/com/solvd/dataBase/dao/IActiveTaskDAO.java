package com.solvd.dataBase.dao;

import com.solvd.dataBase.parser.models.ActiveTasks;

import java.util.List;

public interface IActiveTaskDAO {
    List<ActiveTasks> getAllActiveTasks();
}
