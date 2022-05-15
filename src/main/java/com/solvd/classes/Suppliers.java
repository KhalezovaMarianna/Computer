package com.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Suppliers {
    private static final Logger LOGGER = LogManager.getLogger(Suppliers.class);
    private Materials materials;
    private Materials model;
    private String country;

    public Suppliers(Materials materials, Materials model, String country) {
        this.materials = materials;
        this.model = model;
        this.country = country;
    }

    public Materials getMaterials() {
        return materials;
    }

    public Materials getModel() {
        return model;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "materials=" + materials +
                ", model=" + model +
                ", country='" + country + '\'' +
                '}';
    }
}
