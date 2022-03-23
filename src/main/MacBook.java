package main;

public class MacBook extends Computer implements ILoginID {
    private String model;
    private String operationSystem;
    private static final String NAMEMODEL = "MacBook air";

    static {
        System.out.print(
                " You switched to control MacBook air ");
    }

    public MacBook() {
    }

    public MacBook(String user) {
        super(user);
    }

    public MacBook(Email email) {
        super(email);
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public static void checkModel() {
        System.out.println(NAMEMODEL);
    }


    @Override
    public void send(User sender, User receiver, Email email) {
        System.out.println("Letter was sent by MacBook by " + sender.getName() + " to " + receiver.getName() + " by email " + email.getEmail());
    }

    @Override
    public void launch() {
        System.out.println(getUser() + " was launched ");
    }

    @Override
    public void login() {
        System.out.println(NAMEMODEL + " ID recognized ");
    }

    @Override
    public void shutDown() {
        System.out.println(" MacBook is shutdown");


    }
}

