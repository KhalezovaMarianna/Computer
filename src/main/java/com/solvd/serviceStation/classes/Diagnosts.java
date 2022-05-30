package com.solvd.serviceStation.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Diagnosts {
    private static final Logger LOGGER = LogManager.getLogger(Diagnosts.class);
    private int idDiagnosts;
    private String name;
    private String firstName;
    private String telefonNumber;

    public Diagnosts(int idDiagnosts, String name , String firstName,String telefonNumber) {
        this.idDiagnosts = idDiagnosts;
        this.name = name;
        this.firstName = firstName;
        this.telefonNumber = telefonNumber;
    }

    public int getIdDiagnosts() {
        return idDiagnosts;
    }

    public void setIdDiagnosts(int idDiagnosts) {
        this.idDiagnosts = idDiagnosts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTelefonNumber() {
        return telefonNumber;
    }

    public void setTelefonNumber(String telefonNumber) {
        this.telefonNumber = telefonNumber;
    }

    @Override
    public String toString() {
        return "Diagnosts{" +
                "idDiagnosts=" + idDiagnosts +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", telefonNumber='" + telefonNumber + '\'' +
                '}';
    }
}
