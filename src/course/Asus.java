package course;

import java.util.Objects;

public class Asus extends Computer implements ICheckBattery {
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
        System.out.println("Letter was sent by Asus by " + sender.getName() + " to " + receiver.getName() + " by email " + email.getEmail());
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
        System.out.println(model + " is full ");

    }

    @Override
    public void shutDown() {
        System.out.println(" Asus is shutdown");

    }
}

