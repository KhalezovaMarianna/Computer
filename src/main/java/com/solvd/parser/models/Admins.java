package com.solvd.parser.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@XmlType(propOrder = {"name", "firstName", "telefonNumber"})
public class Admins {
    private static final Logger LOGGER = LogManager.getLogger(Admins.class);
    private String name;
    private String firstName;
    private String telefonNumber;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admins admins = (Admins) o;
        return Objects.equals(name, admins.name) && Objects.equals(firstName, admins.firstName) && Objects.equals(telefonNumber, admins.telefonNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, firstName, telefonNumber);
    }

    @Override
    public String toString() {
        return "Admins{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", telefonNumber='" + telefonNumber + '\'' +
                '}';
    }
}