package com.solvd.dataBase.dao;

import com.solvd.dataBase.dao.myBatisImpl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisWritter {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisWritter.class);

    public static void main(String[] args) {
        IAutoDAO autoDAO = new AutoDAO();
//        LOGGER.info(carDAO.getEntityById(2));
//        LOGGER.info(carDAO.getEntityById(3));
//        Car car = new Car("TEST4000", 2040);
//        car.setId(23);
//        carDAO.getEntityById(5);
//        carDAO.saveEntity(car);
//        carDAO.updateEntity(car);
//        carDAO.removeEntity(car);
        autoDAO.getAllAutos();
        IDiagnostDAO diagnostDAO = new DiagnostDAO();
//        LOGGER.info(compressorDAO.getEntityById(2));
//        Compressor compressor = new Compressor("TEST",4444);
//        compressorDAO.saveEntity(compressor);
//        compressor.setManufacture("Rename");
//        compressor.setId(10);
//        compressorDAO.updateEntity(compressor);
//        compressorDAO.removeEntity(compressor);
        diagnostDAO.getAllDiagnosts();
        IGarageDAO garageDAO = new GarageDAO();
//        Order order = new Order(10,"Test",1,1,2,2);
//        orderDAO.saveEntity(order);
//        order.setPrice(2);
//        orderDAO.updateEntity(order);
//        orderDAO.removeEntity(order);
//        LOGGER.info(orderDAO.getEntityById(10));
        garageDAO.getAllGarages();
//        User user = new User("Test","Test","Test");
        IMasterDAO masterDAO = new MastersDAO();
//        LOGGER.info(userDAO.getEntityById(3));
//        userDAO.saveEntity(user);
//       user.setEmail("Renamed");
//        user.setId(121);
//        userDAO.updateEntity(user);
//        userDAO.removeEntity(user);
//        userDAO.generateUsers("test","test","test@test",10);
        masterDAO.getAllMasters();
//        Worker worker = new Worker(2, "Test", 15, 1);
        ITimeToWorkDAO timeToWorkDAO = new TimeToWorkDAO();
//        workerDAO.updateEntity(worker);
//        workerDAO.removeEntity(worker);
//        LOGGER.info(workerDAO.getEntityById(10));
        timeToWorkDAO.getAllTimeToWork();
    }
}
