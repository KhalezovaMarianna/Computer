package com.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Clients {
    private static final Logger LOGGER = LogManager.getLogger(Clients.class);
    private int idClients;
    private String name;
    private String firstName;
    private String telefonNumber;
    private Autos auto;

    public Clients() {
        this.idClients = idClients;
        this.name = name;
        this.firstName = firstName;
        this.telefonNumber = telefonNumber;
        this.auto = auto;
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

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTelefonNumber() {
        return telefonNumber;
    }

    public int getIdClients() {
        return idClients;
    }

    public void setIdClients(int idClients) {
        this.idClients = idClients;
    }

    public Autos getAuto() {
        return auto;
    }

    public void setAuto(Autos auto) {
        this.auto = auto;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "idClients=" + idClients +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", telefonNumber='" + telefonNumber + '\'' +
                ", auto=" + auto +
                '}';
    }
}
