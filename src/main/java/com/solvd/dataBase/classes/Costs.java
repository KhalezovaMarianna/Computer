package com.solvd.dataBase.classes;

import com.solvd.dataBase.parser.models.Admins;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Costs {
    private static final Logger LOGGER = LogManager.getLogger(Admins.class);
    private int idCosts;
    private String services;
    private String costs;
    private String timeToWork_idTime;

    public Costs(int idCosts, String services, String costs, String timeToWork_idTime) {
        this.idCosts = idCosts;
        this.services = services;
        this.costs = costs;
        this.timeToWork_idTime = timeToWork_idTime;
    }

    public int getIdCosts() {
        return idCosts;
    }

    public void setIdCosts(int idCosts) {
        this.idCosts = idCosts;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getCosts() {
        return costs;
    }

    public void setCosts(String costs) {
        this.costs = costs;
    }

    public String getTimeToWork_idTime() {
        return timeToWork_idTime;
    }

    public void setTimeToWork_idTime(String timeToWork_idTime) {
        this.timeToWork_idTime = timeToWork_idTime;
    }

    @Override
    public String toString() {
        return "Costs{" +
                "idCosts=" + idCosts +
                ", services='" + services + '\'' +
                ", costs='" + costs + '\'' +
                ", timeToWork_idTime='" + timeToWork_idTime + '\'' +
                '}';
    }
}
