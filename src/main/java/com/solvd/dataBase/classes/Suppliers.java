package com.solvd.dataBase.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Suppliers {
    private static final Logger LOGGER = LogManager.getLogger(Suppliers.class);
    private int idSuppliers;
    private String model;
    private String country;

    public Suppliers() {
        this.idSuppliers = idSuppliers;
        this.model = model;
        this.country = country;
    }

    public int getIdSuppliers() {
        return idSuppliers;
    }

    public void setIdSuppliers(int idSuppliers) {
        this.idSuppliers = idSuppliers;
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
                "idSuppliers=" + idSuppliers +
                ", model='" + model + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
