package com.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Masters {
    private static final Logger LOGGER = LogManager.getLogger(Masters.class);
    private String name;
    private String firstName;
    private String telefonNumber;

    public Masters() {
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

    @Override
    public String toString() {
        return "Masters{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", telefonNumber='" + telefonNumber + '\'' +
                '}';
    }
}
