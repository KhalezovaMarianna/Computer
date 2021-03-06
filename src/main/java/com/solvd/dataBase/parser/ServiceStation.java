package com.solvd.dataBase.parser;

import com.solvd.dataBase.parser.dom.DomParser;
import com.solvd.dataBase.parser.jackson.JacksonWritter;
import com.solvd.dataBase.parser.jaxb.JaxbWritter;
import com.solvd.dataBase.parser.models.ActiveTasks;
import com.solvd.dataBase.dao.IDiagnostDAO;
import com.solvd.dataBase.dao.IGarageDAO;
import com.solvd.dataBase.dao.jdbcMySQLImpl.DiagnostDAO;
import com.solvd.dataBase.dao.jdbcMySQLImpl.GarageDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class ServiceStation {
    private static final Logger LOGGER = LogManager.getLogger(ServiceStation.class);

    public void runPool() {
        IGarageDAO garageDAO = new GarageDAO();
        IDiagnostDAO diagnostDAO = new DiagnostDAO();
        Thread thread1 = new Thread(() -> {
            try {
                LOGGER.info(garageDAO.getEntityById(2));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                LOGGER.info(garageDAO.getEntityById(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                LOGGER.info(garageDAO.getEntityById(3));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                LOGGER.info(diagnostDAO.getEntityById(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                LOGGER.info(diagnostDAO.getEntityById(3));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                LOGGER.info(diagnostDAO.getEntityById(50));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) throws SQLException {
//        ServiceStation serviceStation = new ServiceStation();
//        IDiagnostDAO d = new DiagnostDAO();
//        Diagnosts d1 = new Diagnosts(1, "Ivan", "Ivanov", "+37528398847");
//        LOGGER.info(d.getEntityById(2));
//        d.updateEntity(d1);
//        d1.setIdDiagnosts(15);
//        LOGGER.info(d1.getIdDiagnosts() + d1.getName() + d1.getFirstName() + d1.getTelefonNumber());
//        d.updateEntity(d1);
//        d.removeEntity(d1);
//        serviceStation.runPool();
        DomParser domParser = new DomParser();
        try {
            domParser.parse();
        } catch (Exception e) {
            e.printStackTrace();

      }
        ActiveTasks aa = domParser.takeActiveTasks();
        JaxbWritter.marshal(aa);
        ActiveTasks aan = new ActiveTasks();
        try {
            aan = JaxbWritter.unmarhall();
        } catch (FileNotFoundException e) {
            LOGGER.info(e);
        } catch (javax.xml.bind.JAXBException e) {
            e.printStackTrace();
        }
        JacksonWritter.deserialize();
        JacksonWritter.serialize(aan);
        }

    }

