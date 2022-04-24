package com.solvd.computer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(MyThread.class);


    @Override
    public void run() {
        LOGGER.info("this is a new thread");
        LOGGER.info(Thread.currentThread().getName());
        LOGGER.info(Dell.diagonal.LAPTOP);

    }
}
