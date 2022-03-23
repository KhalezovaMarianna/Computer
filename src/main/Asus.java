package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Asus extends Computer implements ICheckBattery {
    private static final Logger LOGGER = LogManager.getLogger(Asus.class);
    private String model;
    private String processor;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }


    public Asus(String user) {
        super(user);
    }

    @Override
    public void send(User sender, User receiver, Email email) {
        LOGGER.info("Letter was sent by Asus by " + sender.getName() + " to " + receiver.getName() + " by email " + email.getEmail());
    }

    @Override
    public String toString() {
        return " asus,with model " + model + " processor " + processor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Asus computer = (Asus) o;
        return this.getUser().equals(computer.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser());
    }

    @Override
    public void checkPower() {
       LOGGER.info(model + " is full ");

    }

    @Override
    public void shutDown() {
        LOGGER.info(" Asus is shutdown");

    }
}

