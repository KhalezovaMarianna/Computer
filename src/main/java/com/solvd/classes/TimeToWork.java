package com.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimeToWork {
    private static final Logger LOGGER = LogManager.getLogger(TimeToWork.class);
    private int idTime;
    private double timeToWork;

    public TimeToWork(int idTime, double timeToWork) {
        this.idTime = idTime;
        this.timeToWork = timeToWork;
    }

    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public double getTimeToWork() {
        return timeToWork;
    }

    public void setTimeToWork(double timeToWork) {
        this.timeToWork = timeToWork;
    }

    @Override
    public String toString() {
        return "TimeToWork{" +
                "idTime=" + idTime +
                ", timeToWork=" + timeToWork +
                '}';
    }
}
