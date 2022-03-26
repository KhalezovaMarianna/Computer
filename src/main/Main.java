package main;

import exceptions.BatteryException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        HashSet<MacBook> operationSystems = new HashSet<MacBook>();

        operationSystems.add(new MacBook("Windows"));
        operationSystems.add(new MacBook("Linux"));
        operationSystems.add(new MacBook("MacOS"));
        LOGGER.info("Operation Systems:  ", operationSystems);
        for (MacBook m : operationSystems) {

            LOGGER.info(m.getOperationSystem());
        }
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.error("error");
        Dell battery = new Dell();
        battery.getBattery();
        User sasha = new User("Sasha");
        User pasha = new User("Pasha");
        Email email1 = new Email("text1", "test1@gmail.ru");
        Email email2 = new Email("text2", "test2@gmail.ru");
        MacBook user1 = new MacBook("user1");
        Computer user2 = new Asus("user2");
        Computer user3 = new Asus("user2");
        LOGGER.info(user2.toString());
        LOGGER.info(user2.equals(user3));
        LOGGER.info(user2 == user3);
        user1.send(pasha, sasha, email1);
        user2.send(sasha, pasha, email2);
        user1.login();
        MacBook.checkModel();
        Dell user4 = new Dell("user4");
        user4.resetToDefaultAllDells();
        try {
            user4.showMouseModel();
        } catch (Exception e) {
            throw new Exception(e.getCause());
        }
    }
}
