package com.solvd.serviceStation.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Materials {
    private static final Logger LOGGER = LogManager.getLogger(Materials.class);
    private int idMaterials;
    private String material;
    private String model;

    public Materials(String material, String model) {
        this.idMaterials=idMaterials;
        this.material = material;
        this.model = model;
    }

    public int getIdMaterials() {
        return idMaterials;
    }

    public void setIdMaterials(int idMaterials) {
        this.idMaterials = idMaterials;
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
                "idMaterials=" + idMaterials +
                ", material='" + material + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
