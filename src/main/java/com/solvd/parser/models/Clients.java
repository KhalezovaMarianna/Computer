package com.solvd.parser.models;

import com.solvd.serviceStation.classes.Autos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Clients {
    private static final Logger LOGGER = LogManager.getLogger(Clients.class);

    private String name;
    private String firstName;
    private String telefonNumber;
    private Autos auto;

    public Clients() {
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


    public Autos getAuto() {
        return auto;
    }

    public void setAuto(Autos auto) {
        this.auto = auto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return Objects.equals(name, clients.name) && Objects.equals(firstName, clients.firstName) && Objects.equals(telefonNumber, clients.telefonNumber) && Objects.equals(auto, clients.auto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, firstName, telefonNumber, auto);
    }

    @Override
    public String toString() {
        return "Clients{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", telefonNumber='" + telefonNumber + '\'' +
                ", auto=" + auto +
                '}';
    }
}
