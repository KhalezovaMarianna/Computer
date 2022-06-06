package com.solvd.dataBase.services;

import com.solvd.dataBase.classes.Autos;
import com.solvd.dataBase.classes.TimeToWork;
import com.solvd.dataBase.dao.IAutoDAO;
import com.solvd.dataBase.dao.ITimeToWorkDAO;
import com.solvd.dataBase.dao.jdbcMySQLImpl.AutoDAO;
import com.solvd.dataBase.dao.jdbcMySQLImpl.TimeToWorkDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bonus {
    private static final Logger LOGGER = LogManager.getLogger(Bonus.class);

    public static void makeBonus(double timeToWork, String bonus) {
        if (bonus == null) throw new IllegalArgumentException("The bonus must exist" + bonus);
        ITimeToWorkDAO timeToWorkDAO = new TimeToWorkDAO();
        IAutoDAO autoDAO = new AutoDAO();
        List<TimeToWork> bonusTimes = new ArrayList<>();
        List<Autos> autos = autoDAO.getAutos().stream().filter(c -> c.getStateNumber() != null).collect(Collectors.toList());
        List<TimeToWork> timeToWorks = TimeToWorkDAO.getTimeToWork();
        if (!autos.isEmpty()) {
            for (int i = 0; i < autos.size(); i++) {
                for (TimeToWork o : timeToWorks) {
                    if (o.getTimeToWork() == autos.get(i).getStateNumber()) {
                        o.setTimeToWork(o.getTimeToWork());
                        bonusTimes.add(o);
                    }
                }
            }
        }
        for (int i = 0; i < bonusTimes.size(); i++) {
            LOGGER.info("Bonus time is exist"+ bonusTimes.get(i));
            timeToWorkDAO.updateEntity(bonusTimes.get(i));
        }
    }

    public static void main(String[] args) {
        makeBonus(4, "cupOfCoffee");
    }
}
