package com.solvd.computer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.computer.TypeOfEmail.*;

public abstract class Computer implements ILaunch, IShutDown {
    private static final Logger LOGGER = LogManager.getLogger(Computer.class);
    private String user;
    private Email email;
    private Keyboard keyboard;
    private TypeOfEmail typeOfEmail;


    public Computer() {
    }

    public Computer(String user) {
        this.user = user;
    }

    public Computer(Email email) {
        this.email = email;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public abstract void send(User sender, User receiver, Email email);

    public void typeOfEmail() {

        switch (typeOfEmail) {
            case GMAIL:
                LOGGER.info("Send from Gmail");
                break;
            case EMAIL:
                LOGGER.info("Send from Email");
                break;
            case YANDEX:
                LOGGER.info("Send from Yandex");
                break;
        }
    }

}
