package com.solvd.dataBase.services;

import com.solvd.dataBase.dao.factory.AbstractFactory;
import com.solvd.dataBase.dao.factory.MyBatisDAOFactory;
import com.solvd.dataBase.models.AdditionalTime;
import com.solvd.dataBase.models.Autos;
import com.solvd.dataBase.models.TimeToWork;
import com.solvd.dataBase.dao.IAutoDAO;
import com.solvd.dataBase.dao.ITimeToWorkDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bonus {
    private static final Logger LOGGER = LogManager.getLogger(Bonus.class);
    private static List<AdditionalTime> additionalTimes = new ArrayList<>();

    public static List<AdditionalTime> getAdditionalTimes() {
        return additionalTimes;
    }

    public static void setAdditionalTimes(List<AdditionalTime> additionalTimes) {
        Bonus.additionalTimes = additionalTimes;
    }

    public static void makeBonus(double timeToWork, String bonus) {
        if (bonus == null) throw new IllegalArgumentException("The bonus must exist" + bonus);
        ITimeToWorkDAO timeToWorkDAO = (ITimeToWorkDAO) new AbstractFactory().<MyBatisDAOFactory>getFactory("mybatis").createDAO("timeToWork");
        IAutoDAO autoDAO = (IAutoDAO) new AbstractFactory().<MyBatisDAOFactory>getFactory("mybatis").createDAO("auto");
        List<Autos> bonusTimes = new ArrayList<>();
        List<Autos> autos = autoDAO.getAllAutos();
        List<TimeToWork> timeToWorks = timeToWorkDAO.getAllTimeToWork().stream().filter(c -> c.getTimeToWork() >= 3).collect(Collectors.toList());
        if (!autos.isEmpty()) {
            for (int i = 0; i < timeToWorks.size(); i++) {
                for (Autos o : autos) {
                    if (o.getStateNumber() == timeToWorks.get(i).getTimeToWork()) {
                        o.setStateNumber(o.getStateNumber());
                        bonusTimes.add(o);
                    }
                }
            }
        }
        for (int i = 0; i < bonusTimes.size(); i++) {
            LOGGER.info("Bonus time is exist" + bonusTimes.get(i));
            autoDAO.updateEntity(bonusTimes.get(i));
        }
    }
    public static void addAdditionalTime(int idTime, double time) throws SQLException {
        TimeToWork timeToWork = (TimeToWork) new AbstractFactory().<MyBatisDAOFactory>getFactory("mybatis").createDAO("timeToWork").getEntityById(idTime);
        additionalTimes.add(timeToWork);
        timeToWork.setTimeToWork(time);
        new AbstractFactory().<MyBatisDAOFactory>getFactory("mybatis").createDAO("timeToWork").updateEntity(timeToWork);
        for (AdditionalTime a : additionalTimes) {
            a.addAdditionalTime();
        }
    }
    public static void main(String[] args) throws SQLException {
        try {
            makeBonus(4, "cupOfCoffee");
        } catch (NullPointerException e) {
            LOGGER.info("We don't have autos for bonus");
        }
        addAdditionalTime(1,2.5);

    }
}
