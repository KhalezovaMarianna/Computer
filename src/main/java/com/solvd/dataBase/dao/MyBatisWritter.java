package com.solvd.dataBase.dao;

import com.solvd.dataBase.dao.myBatisImpl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisWritter {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisWritter.class);

    public static void main(String[] args) {
        IAutoDAO autoDAO = new AutoDAO();
        autoDAO.getAllAutos();
        IDiagnostDAO diagnostDAO = new DiagnostDAO();
        diagnostDAO.getAllDiagnosts();
        IGarageDAO garageDAO = new GarageDAO();
        garageDAO.getAllGarages();
        IMasterDAO masterDAO = new MastersDAO();
        masterDAO.getAllMasters();
        ITimeToWorkDAO timeToWorkDAO = new TimeToWorkDAO();
        timeToWorkDAO.getAllTimeToWork();
    }
}
