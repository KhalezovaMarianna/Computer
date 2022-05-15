package com.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Suppliers {
    private static final Logger LOGGER = LogManager.getLogger(Suppliers.class);
    private String model;
    private String country;

    public Suppliers() {

        this.model = model;
        this.country = country;
    }



    public String getModel() {
        return model;
    }

    public String getCountry() {
        return country;
    }



    public void setModel(String model) {
        this.model = model;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "model='" + model + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
