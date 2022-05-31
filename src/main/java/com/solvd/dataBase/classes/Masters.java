package com.solvd.dataBase.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Masters {
    private static final Logger LOGGER = LogManager.getLogger(Masters.class);
    private int idMasters;
    private String name;
    private String firstName;
    private String telefonNumber;

    public Masters() {
        this.idMasters=idMasters;
        this.name = name;
        this.firstName = firstName;
        this.telefonNumber = telefonNumber;

    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTelefonNumber() {
        return telefonNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setTelefonNumber(String telefonNumber) {
        this.telefonNumber = telefonNumber;
    }

    public int getIdMasters() {
        return idMasters;
    }

    public void setIdMasters(int idMasters) {
        this.idMasters = idMasters;
    }

    @Override
    public String toString() {
        return "Masters{" +
                "idMasters=" + idMasters +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", telefonNumber='" + telefonNumber + '\'' +
                '}';
    }
}
