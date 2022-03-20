package course;

public class Dell extends Computer implements CheckingTheWebcam {
    private String processor;
    private double battery;

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


    public Dell(String user) {
        super(user);
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

    }

    @Override
    public void shutDown() {
        System.out.println(" Dell is shutdown");


    }
}
