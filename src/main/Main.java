package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.error("error");

         User sasha = new User("Sasha");
        User pasha = new User("Pasha");
        Email email1 = new Email("text1", "test1@gmail.ru");
        Email email2 = new Email("text2", "test2@gmail.ru");
        MacBook user1 = new MacBook("user1");
        Asus user2 = new Asus("user2");
        Asus user3 = new Asus("user2");
        System.out.println(user2.toString());
        System.out.println((user2.equals(user3)));
        System.out.println(user2 == user3);
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
