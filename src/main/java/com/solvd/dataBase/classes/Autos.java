package com.solvd.dataBase.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Autos {
    private static final Logger LOGGER = LogManager.getLogger(Autos.class);
    private int stateNumber;
    private String model;

    public void setStateNumber(int stateNumber) {
        this.stateNumber = stateNumber;
    }

    public Autos setModel(String model) {
        this.model = model;
        return null;
    }

    public Autos(String model) {
        this.model = model;
    }

    public Autos(int stateNumber, String model) {
        this.stateNumber = stateNumber;
        this.model = model;
    }

    public int getStateNumber() {
        return stateNumber;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Autos{" +
                "stateNumber=" + stateNumber +
                ", model='" + model + '\'' +
                '}';
    }
}
