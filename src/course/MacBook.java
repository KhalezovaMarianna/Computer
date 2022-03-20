package course;

public class MacBook extends Computer implements LoginID {
    private String operationSystem;
    private String model;

    public MacBook() {
    }

    public MacBook(String user) {
        super(user);
    }

    public MacBook(Email email) {
        super(email);
    }

    @Override
    public void send(User sender, User receiver, Email email) {
        System.out.println("Letter was sent by MacBook by " + sender.getName() + " to " + receiver.getName() + " by email " + email.getEmail());
    }

    @Override
    public void login() {
        System.out.println(MacBookModel.MACBOOK + " ID recognized ");
    }

    @Override
    public void shutDown() {
        System.out.println(" MacBook is shutdown");


    }
}

