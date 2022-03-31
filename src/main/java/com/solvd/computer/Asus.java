package com.solvd.computer;

import com.solvd.exceptions.ProcessorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Asus extends Computer implements ICheckBattery {
    private static final Logger LOGGER = LogManager.getLogger(Asus.class);
    private String model;
    private String processor;

    public Asus(String user) {
        super(user);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) throws ProcessorException {
        if (Objects.equals(processor, "apple")) {
            throw new ProcessorException("is incorrect processor for Asus");
        }
        this.processor = processor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asus asus = (Asus) o;
        return Objects.equals(processor, asus.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processor);
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
    public void checkPower() {
        LOGGER.info(model + " is full ");

    }

    @Override
    public void shutDown() {
        LOGGER.info(" Asus is shutdown");

    }
}

