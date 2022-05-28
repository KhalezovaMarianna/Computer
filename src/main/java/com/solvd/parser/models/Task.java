package com.solvd.parser.models;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.Objects;

public class Task {
    private Services services;
    private Clients clients;

    public Services getServices() {
        return services;
    }
@XmlElement(name ="service")
    public void setServices(Services services) {
        this.services = services;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(services, task.services) && Objects.equals(clients, task.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(services, clients);
    }

    @Override
    public String toString() {
        return "Task{" +
                "services=" + services +
                ", clients=" + clients +
                '}';
    }
}
