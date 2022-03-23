package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MacBook extends Computer implements ILoginID {
    private static final Logger LOGGER = LogManager.getLogger(MacBook.class);
    private String model;
    private String operationSystem;
    private static final String NAMEMODEL = "MacBook air";

    static {
       LOGGER.info(" You switched to control MacBook air ");
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
        LOGGER.info(NAMEMODEL);
    }


    @Override
    public void send(User sender, User receiver, Email email) {
       LOGGER.info("Letter was sent by MacBook by " + sender.getName() + " to " + receiver.getName() + " by email " + email.getEmail());
    }

    @Override
    public void launch() {
        LOGGER.info(getUser() + " was launched ");
    }

    @Override
    public void login() {
        LOGGER.info(NAMEMODEL + " ID recognized ");
    }

    @Override
    public void shutDown() {
        LOGGER.info(" MacBook is shutdown");


    }
}

