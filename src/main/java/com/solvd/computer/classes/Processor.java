package com.solvd.computer.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Processor {

    private String model;
    private int creationDate;

    public Processor(String model, int creationDate) {
        this.model = model;
        this.creationDate = creationDate;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }


}
