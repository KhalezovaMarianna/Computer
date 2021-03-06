package com.solvd.dataBase.parser.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Services {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
    private Double timeToWork;
    private String service;
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date dateOfChange;

    public Double getTimeToWork() {
        return timeToWork;
    }

    public void setTimeToWork(Double timeToWork) {
        this.timeToWork = timeToWork;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Date getDateOfChange(Date birthday) {
        return dateOfChange;
    }

    public void setDateOfChange(Date dateOfChange) {
        this.dateOfChange = dateOfChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Services services = (Services) o;
        return dateOfChange == services.dateOfChange && Objects.equals(timeToWork, services.timeToWork) && Objects.equals(service, services.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeToWork, service, dateOfChange);
    }

    @Override
    public String toString() {
        return "Services{" +
                "timeToWork=" + timeToWork +
                ", service='" + service + '\'' +
                ", dateOfChange=" + dateOfChange +
                '}';
    }
}
