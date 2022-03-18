package course;

public class Asus extends Computer {
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
}

