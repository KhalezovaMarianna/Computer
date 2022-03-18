package course;

public class MacBook extends Computer {
private String operationSystem;
private String model;
    public MacBook(String user) {
        super(user);
    }

    public MacBook(Email email) {
        super(email);
    }

    @Override
    public void send(User sender, User receiver, Email email) {
        System.out.println("Letter was sent by MacBook by " + sender.getName() + " to " + receiver.getName()+ " by email "+ email.getEmail());
    }
}
