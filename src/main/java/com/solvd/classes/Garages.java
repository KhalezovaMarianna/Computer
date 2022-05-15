package com.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Garages {
    private static final Logger LOGGER = LogManager.getLogger(Garages.class);
    private String adress;
    private int maxWorkers;

    public Garages(String adress, int maxWorkers) {
        this.adress = adress;
        this.maxWorkers = maxWorkers;
    }

    public String getAdress() {
        return adress;
    }

    public int getMaxWorkers() {
        return maxWorkers;
    }

    @Override
    public String toString() {
        return "Garages{" +
                "adress='" + adress + '\'' +
                ", maxWorkers=" + maxWorkers +
                '}';
    }
}