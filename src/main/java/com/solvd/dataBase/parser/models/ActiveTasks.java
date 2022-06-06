package com.solvd.dataBase.parser.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement(name = "activeTasks")
@XmlType(propOrder = {"id", "name", "address", "employeers", "task"})
@JsonPropertyOrder({"id", "name", "address", "employeers", "task"})

public class ActiveTasks {
    private static final Logger LOGGER = LogManager.getLogger(ActiveTasks.class);

    @JsonProperty
    private int id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String address;
    @JsonProperty
    private List<Employeers> employeers = new ArrayList<>();
    @JsonProperty
    private List<Task> task = new ArrayList<>();

    public ActiveTasks() {
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement
    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employeers> getEmployeers() {
        return employeers;
    }

    @XmlElement
    public void setEmployeers(List<Employeers> employeers) {
        this.employeers = employeers;
    }

    public List<Task> getTask() {
        return task;
    }

    @XmlElement
    public void setTask(List<Task> task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "ActiveTasks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", employeers=" + employeers +
                ", task=" + task +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiveTasks that = (ActiveTasks) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(employeers, that.employeers) && Objects.equals(task, that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, employeers, task);
    }
}

