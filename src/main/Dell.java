package main;

import java.util.Objects;

public class Dell extends Computer implements ICheckingTheWebcam {
    private String processor;
    private double battery;
    private String mouse;

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }


    public Dell(String user) {
        super(user);
    }


    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
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
        System.out.println("Letter was sent by Dell by " + sender.getName() + " to " + receiver.getName() + " by email " + email.getEmail());
    }

    public final void resetToDefaultAllDells() {
        System.out.println(" All Dell computers were resetted to default ");
    }

    @Override
    public void checkTheWebcam() {
        System.out.println("Webcam is working");

    }

    @Override
    public void shutDown() {
        System.out.println(" Dell is shutdown");


    }

    public void showMouseModel() {
        throw new NullPointerException();
    }

}
