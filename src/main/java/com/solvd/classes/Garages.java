package com.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Garages {
    private static final Logger LOGGER = LogManager.getLogger(Garages.class);
    private int idGarage;
    private String adress;
    private int maxWorkers;

    public Garages(int idGarage, String adress, int maxWorkers) {
        this.idGarage = idGarage;
        this.adress = adress;
        this.maxWorkers = maxWorkers;
    }

    public Garages() {
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setMaxWorkers(int maxWorkers) {
        this.maxWorkers = maxWorkers;
    }

    public void setIdGarage(int idGarage) {
        this.idGarage = idGarage;
    }

    @Override
    public String toString() {
        return "Garages{" +
                "idGarage=" + idGarage +
                ", adress='" + adress + '\'' +
                ", maxWorkers=" + maxWorkers +
                '}';
    }

    public String getAdress() {
        return adress;
    }

    public int getMaxWorkers() {
        return maxWorkers;
    }

    public int getIdGarage() {
        return idGarage;
    }

}
