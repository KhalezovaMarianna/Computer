package course;

public class MacBook extends Computer implements ILoginID {
    private MacBookModel model;
    private String operationSystem;

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


    public MacBookModel getModel() {
        return model;
    }

    public void setModel(MacBookModel model) {
        this.model = model;
    }


    @Override
    public void send(User sender, User receiver, Email email) {
        System.out.println("Letter was sent by MacBook by " + sender.getName() + " to " + receiver.getName() + " by email " + email.getEmail());
    }
@Override
public void launch(){
        System.out.println(getUser()+" was launched ");
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

