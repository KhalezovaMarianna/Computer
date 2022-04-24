package com.solvd.computer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyRunnable implements Runnable{
    private static final Logger LOGGER = LogManager.getLogger(MyRunnable.class);
    @Override
    public void run(){
      LOGGER.info(Thread.currentThread().getName());
    }
}
