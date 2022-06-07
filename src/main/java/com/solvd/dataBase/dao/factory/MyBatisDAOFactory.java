package com.solvd.dataBase.dao.factory;

import com.solvd.dataBase.dao.IBaseDAO;
import com.solvd.dataBase.dao.jdbcMySQLImpl.*;

public class MyBatisDAOFactory {
    public IBaseDAO createDAO(String dao){
        switch (dao){
            case "auto": {
                return new AutoDAO();
            }
            case "diagnost":{
                return new DiagnostDAO();
            }
            case "garage":{
                return new GarageDAO();
            }
            case "master":{
                return new MastersDAO();
            }
            case "timeToWork":{
                return new TimeToWorkDAO();
            }
        }
        return null;
    }
}
