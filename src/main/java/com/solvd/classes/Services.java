package com.solvd.classes;

public class Services {
    private int idServices;
    private String service;
    private TimeToWork timeToWork;

    public Services() {
        this.idServices = idServices;
        this.service = service;
        this.timeToWork = timeToWork;
    }

    public int getIdServices() {
        return idServices;
    }

    public void setIdServices(int idServices) {
        this.idServices = idServices;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public TimeToWork getTimeToWork(double v) {
        return timeToWork;
    }

    public void setTimeToWork(TimeToWork timeToWork) {
        this.timeToWork = timeToWork;
    }

    @Override
    public String toString() {
        return "Services{" +
                "idServices=" + idServices +
                ", service='" + service + '\'' +
                ", timeToWork=" + timeToWork +
                '}';
    }
}
