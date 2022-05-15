package com.solvd.parser;

import com.solvd.classes.Clients;
import com.solvd.classes.Garages;
import com.solvd.classes.Masters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Service {
    private static final Logger LOGGER = LogManager.getLogger(Service.class);

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document doc = builder.parse(new File(System.getProperty("user.dir") + "/src/main/resources/service.xml"));
        NodeList nodeList = doc.getElementsByTagName("service");
        nodeList.getLength();
        Service service = new Service();
        Masters masters = new Masters();
        Node node = nodeList.item(0);
        Element element = (Element) node;
        masters.setName(element.getElementsByTagName("name").item(0).getTextContent());
        masters.setFirstName(element.getElementsByTagName("firstName").item(0).getTextContent());
        masters.setTelefonNumber(element.getElementsByTagName("telefonNumber").item(0).getTextContent());
        LOGGER.info(masters);
        Element garageElement = (Element) node;
        Garages garage = new Garages();
        garage.setMaxWorkers(Integer.parseInt(garageElement.getElementsByTagName("maxWorkers").item(0).getTextContent()));
        garage.setAdress(garageElement.getElementsByTagName("adress").item(0).getTextContent());
        LOGGER.info(garage);
        Element clientsElement = (Element) node;
        Clients clients = new Clients();
        clients.setFirstName(clientsElement.getElementsByTagName("firstName").item(0).getTextContent());
        clients.setName(clientsElement.getElementsByTagName("name").item(0).getTextContent());
        clients.setTelefonNumber(clientsElement.getElementsByTagName("telefonNumber").item(0).getTextContent());
        System.out.println(clients);
    }

}
