package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        Dell batteryNumber = new Dell();
        batteryNumber.addRandom();

        LOGGER.info("Battery serial number" + batteryNumber.toString());

        HashSet<MacBook> operationSystems = new HashSet<MacBook>();

        operationSystems.add(new MacBook("Windows"));
        operationSystems.add(new MacBook("Linux"));
        operationSystems.add(new MacBook("MacOS"));
        LOGGER.info("Operation Systems:  ", operationSystems);
        for (MacBook m : operationSystems) {

            LOGGER.info(m.getOperationSystem());
        }
        LinkedList<String> processorModels = new LinkedList<>();

        processorModels.add("intel core i9");
        processorModels.add("intel core i7");
        processorModels.addLast("intel xeon e3"); // добавляем на последнее место
        processorModels.addFirst("intel core i5"); // добавляем на первое место

        LOGGER.info("List has %d elements \n", processorModels.size());
        for (String processorModel : processorModels) {

            LOGGER.info(processorModels);
        }
        List<User> users = new ArrayList<User>();
        users.add(new User("Masha"));
        users.add(new User("Sasha"));
        users.add(new User("Denis"));
        /*for(int i=0;i< users.size();i++)
        {
            LOGGER.info("user of computer  "+ users.get(i));
        }*/
        Collections.reverse(users);
        System.out.println(users);


        Dell battery = new Dell();
        battery.getBattery();
        User sasha = new User("Sasha");
        User pasha = new User("Pasha");
        Email email1 = new Email("text1", "test1@gmail.ru");
        Email email2 = new Email("text2", "test2@gmail.ru");
        Computer user2 = new Asus("user2");
        Computer user3 = new Asus("user2");
        LOGGER.info(user2.toString());
        LOGGER.info(user2.equals(user3));
        LOGGER.info(user2 == user3);
        user3.send(pasha, sasha, email1);
        user2.send(sasha, pasha, email2);
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
