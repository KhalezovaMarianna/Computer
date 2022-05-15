/*
package com.solvd.computer;


import com.solvd.exceptions.ProcessorException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        Dell lock1 = new Dell();
        Dell lock2 = new Dell();
        Thread myThread = new Thread(() -> {
            LOGGER.info(Thread.currentThread().getName() + "start");
            synchronized (lock1) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {

                }
            }
            LOGGER.info(Thread.currentThread().getName() + "end");
        },
                "MyThread");


        Thread thread2 = new Thread(() -> {
            LOGGER.info(Thread.currentThread().getName() + "start");
            synchronized (lock2) {

                synchronized (lock1) {

                }
            }
            MyRunnable myRunnable = new MyRunnable();
            Thread thread =new Thread(myRunnable);
            thread.start();

            LOGGER.info(Thread.currentThread().getName() + "end");
        }, "Thread2");
        myThread.start();
        thread2.start();

        IDoSomething f = () -> LOGGER.info("Hello from Computer");
        f.doSmth();
        IBroken s = () -> LOGGER.info("Processor hasn't found");
        s.processorIsBroken();
        ISendAlert a = () -> LOGGER.info("Alert was send");
        a.sendAlert();
        Searchable d = () -> LOGGER.info(Dell.diagonal.LAPTOP);

        try {
            File file = new File("C:/Users/Marianna/IdeaProjects/Task_4/src/main/resources/Hello.txt");
            String string = StringUtils.lowerCase(FileUtils.readFileToString(file, StandardCharsets.UTF_8)).replaceAll("\\s*(\\s|,|!|\\.)\\s*", " ");
            String[] content = string.split(" ");
            Set<String> hashSet = new HashSet(List.of(content));
            List<String> list = new ArrayList<>();
            for (String str : hashSet) {
                list.add(str + " " + StringUtils.countMatches(string, str));
            }
            FileUtils.writeLines(new File("C:/Users/Marianna/IdeaProjects/Task_4/src/main/resources/newFile.txt"), list);
        } catch (FileNotFoundException ex) {
            LOGGER.info(ex.getMessage());
        } catch (IOException e) {
            LOGGER.info(e);
        }


        Dell batteryNumber = new Dell();
        batteryNumber.addRandom();

        LOGGER.info("Battery serial number" + batteryNumber.toString());
        List<Computer> computers = new ArrayList<Computer>();
        if (!computers.isEmpty() && computers.stream().allMatch(c -> c != null)) {
            LOGGER.info("All computers have users");

        } else {
            LOGGER.info("Not all");
        }


        HashSet<MacBook> operationSystems = new HashSet<MacBook>();

        operationSystems.add(new MacBook("Windows"));
        operationSystems.add(new MacBook("Linux"));
        operationSystems.add(new MacBook("MacOS"));
        LOGGER.info("Operation Systems:  ", operationSystems);
        for (MacBook m : operationSystems) {

            LOGGER.info(m.getOperationSystem());
        }
        LinkedList<Processor> processorModels = new LinkedList<>();

        processorModels.add(new Processor("intel core i9", 2020));
        processorModels.add(new Processor("intel core i7", 2017));
        processorModels.addLast(new Processor("intel xeon e3", 2016));
        processorModels.addFirst(new Processor("intel core i5", 2014));
        LOGGER.info(processorModels.stream().map(Processor::getModel).collect(Collectors.toList()));
        LOGGER.info(" List has %d elements ", processorModels.size());
        for (Processor processorModel : processorModels) {
            LOGGER.info(processorModels);
        }
        List<User> users = new ArrayList<User>();
        users.add(new User("Masha"));
        users.add(new User("Sasha"));
        users.add(new User("Denis"));
        for (User user : users) {
            LOGGER.info("user of computer  " + user.getName());
        }
        CustomLinkedList<Email> emails = new CustomLinkedList<>();
        emails.addFirst(new Email("denis@gmail.ru"));
        emails.addLast(new Email("sasha@mail.ru"));
        LOGGER.info(emails.getFirst().getEmail());
        Dell battery = new Dell();
        battery.getBattery();
        User pasha = new User("Pasha");
        Email email1 = new Email("text1", "test1@gmail.ru");
        Email email2 = new Email("text2", "test2@gmail.ru");
        Computer user2 = new Asus("user2");
        Computer user3 = new Asus("user2");
        LOGGER.info(user2.toString());
        LOGGER.info(user2.equals(user3));
        LOGGER.info(user2 == user3);
        user3.send(pasha, users.stream().filter(u -> u.getName().equals("Sasha")).findFirst().get(), email1);
        user2.send(users.stream().filter(u -> u.getName().equals("Denis")).findFirst().get(), pasha, email2);
        MacBook.checkModel();
        Dell user4 = new Dell("user4");
        user4.resetToDefaultAllDells();
        user4.showMouseModel();
        Asus processor = new Asus("Pasha");
        try {
            processor.setProcessor("asus");
        } catch (ProcessorException e) {
            LOGGER.info(e);
        }
        try {
            user4.typeOfEmail();
        } catch (NullPointerException e) {
            LOGGER.info("not found type of email");
        }
        int windowsIndex = Asus.OperationSystem.WINDOWS.ordinal();
        LOGGER.info(windowsIndex);


    }
}


*/
