package com.solvd.dataBase.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Autos {
    private static final Logger LOGGER = LogManager.getLogger(Autos.class);
    private Integer stateNumber;
    private String model;

    public Autos(Integer stateNumber) {
        this.stateNumber = stateNumber;
    }
    public Autos(){}
    public void setStateNumber(Integer stateNumber) {
        this.stateNumber = stateNumber;
    }

    public Autos setModel(String model) {
        this.model = model;
        return null;
    }

    public Autos(String model) {
        this.model = model;
    }

    public Autos(Integer stateNumber, String model) {
        this.stateNumber = stateNumber;
        this.model = model;
    }

    public Integer getStateNumber() {
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
