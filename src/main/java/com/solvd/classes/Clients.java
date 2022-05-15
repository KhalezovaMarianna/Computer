package com.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Clients {
    private static final Logger LOGGER = LogManager.getLogger(Clients.class);
    private String name;
    private String firstName;
    private String telefonNumber;
    private Autos auto;

    public Clients(String name, String firstName, String telefonNumber, Autos auto) {
        this.name = name;
        this.firstName = firstName;
        this.telefonNumber = telefonNumber;
        this.auto = auto;
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
}
