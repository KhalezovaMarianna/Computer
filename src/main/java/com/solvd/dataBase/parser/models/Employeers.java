package com.solvd.dataBase.parser.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class Employeers {
    @JsonProperty
    private Admins admins;

    public Admins getAdmins() {
        return admins;
    }

    public void setAdmins(Admins admins) {
        this.admins = admins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employeers that = (Employeers) o;
        return Objects.equals(admins, that.admins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(admins);
    }

    @Override
    public String toString() {
        return "Employeers{" +
                "admins=" + admins +
                '}';
    }
}