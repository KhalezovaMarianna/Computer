package com.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActiveTasks {
    private static final Logger LOGGER = LogManager.getLogger(ActiveTasks.class);
    private int idActiveTasks;
    private Services services_idServices;
    private Clients clients_idClients;

    public ActiveTasks(int idActiveTasks, Services services_idServices, Clients clients_idClients) {
        this.idActiveTasks = idActiveTasks;
        this.services_idServices = services_idServices;
        this.clients_idClients = clients_idClients;
    }

    public int getIdActiveTasks() {
        return idActiveTasks;
    }

    public void setIdActiveTasks(int idActiveTasks) {
        this.idActiveTasks = idActiveTasks;
    }

    public Services getServices_idServices() {
        return services_idServices;
    }

    public void setServices_idServices(Services services_idServices) {
        this.services_idServices = services_idServices;
    }

    public Clients getClients_idClients() {
        return clients_idClients;
    }

    public void setClients_idClients(Clients clients_idClients) {
        this.clients_idClients = clients_idClients;
    }

    @Override
    public String toString() {
        return "ActiveTasks{" +
                "idActiveTasks=" + idActiveTasks +
                ", services_idServices=" + services_idServices +
                ", clients_idClients=" + clients_idClients +
                '}';
    }
}
