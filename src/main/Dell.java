package main;

import exceptions.BatteryException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Dell extends Computer implements ICheckingTheWebcam {
    private static final Logger LOGGER = LogManager.getLogger(Dell.class);
    private String processor;
    private double battery;
    private String mouse;

    public Dell() {
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }


    public Dell(String user) {
        super(user);
    }


    public void getBattery() {
        Dell battery = new Dell();
        try {
            battery.setBattery(-10);
        } catch (BatteryException e) {
            e.printStackTrace();
        }

    }

    public void setBattery(double battery) throws BatteryException {
        if (battery <= 0) {
            throw new BatteryException("Battery is incorrect");
        }
        this.battery = battery;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dell dell = (Dell) o;
        return Double.compare(dell.battery, battery) == 0 && Objects.equals(processor, dell.processor) && Objects.equals(mouse, dell.mouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processor, battery, mouse);
    }


    @Override
    public void send(User sender, User receiver, Email email) {
        LOGGER.info("Letter was sent by Dell by " + sender.getName() + " to " + receiver.getName() + " by email " + email.getEmail());
    }

    public final void resetToDefaultAllDells() {
        LOGGER.info(" All Dell computers were resetted to default ");
    }

    @Override
    public void checkTheWebcam() {
        LOGGER.info("Webcam is working");

    }

    @Override
    public void shutDown() {
        LOGGER.info(" Dell is shutdown");


    }

    public void showMouseModel() {
        throw new NullPointerException();
    }

}
