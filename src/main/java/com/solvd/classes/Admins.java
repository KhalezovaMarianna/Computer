package com.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Admins {
    private static final Logger LOGGER = LogManager.getLogger(Admins.class);
    private int idAdmins;
    private String name;
    private String firstName;
    private String telefonNumber;

    public Admins(int idAdmins, String name, String firstName, String telefonNumber) {
        this.idAdmins = idAdmins;
        this.name = name;
        this.firstName = firstName;
        this.telefonNumber = telefonNumber;
    }

    public int getIdAdmins() {
        return idAdmins;
    }

    public void setIdAdmins(int idAdmins) {
        this.idAdmins = idAdmins;
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
        return "Admins{" +
                "idAdmins=" + idAdmins +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", telefonNumber='" + telefonNumber + '\'' +
                '}';
    }
}
