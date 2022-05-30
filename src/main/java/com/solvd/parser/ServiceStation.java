package com.solvd.parser;

import com.solvd.parser.dom.DomParser;
import com.solvd.parser.jackson.JacksonWritter;
import com.solvd.parser.jaxb.JaxbWritter;
import com.solvd.parser.models.ActiveTasks;
import com.solvd.parser.models.Services;
import jakarta.xml.bind.JAXBException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class ServiceStation {
    private static final Logger LOGGER = LogManager.getLogger(ServiceStation.class);

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, SQLException {

        DomParser domParser = new DomParser();
        try {
            domParser.parse();
        } catch (Exception e) {
            LOGGER.info(e);
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
