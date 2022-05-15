package com.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Masters {
    private static final Logger LOGGER = LogManager.getLogger(Masters.class);
    private String name;
    private String firstName;
    private String telefonNumber;

    public Masters(String name, String firstName, String telefonNumber) {
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

    @Override
    public String toString() {
        return "Masters{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", telefonNumber='" + telefonNumber + '\'' +
                '}';
    }
}
