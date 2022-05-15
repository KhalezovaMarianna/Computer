package com.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Materials {
    private static final Logger LOGGER = LogManager.getLogger(Materials.class);
    private String material;
    private String model;

    public Materials(String material, String model) {
        this.material = material;
        this.model = model;
    }

    public String getMaterial() {
        return material;
    }

    public String getModel() {
        return model;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Materials{" +
                "material='" + material + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
