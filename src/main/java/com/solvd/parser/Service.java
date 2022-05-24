package com.solvd.parser;

import com.solvd.classes.Clients;
import com.solvd.classes.Garages;
import com.solvd.classes.Masters;
import com.solvd.classes.Suppliers;
import com.solvd.jdbc.GarageDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private static final Logger LOGGER = LogManager.getLogger(Service.class);

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, SQLException {
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
        LOGGER.info(clients);
        int index = nodeList.getLength();
        List<Suppliers> supplier = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            Suppliers suppliers = new Suppliers();
            Node node1 = nodeList.item(i);
            Element suppliersElement = (Element) node1;
            suppliers.setModel(suppliersElement.getElementsByTagName("model").item(i).getTextContent());
            suppliers.setCountry(suppliersElement.getElementsByTagName("country").item(i).getTextContent());
            supplier.add(suppliers);


        }
        LOGGER.info(supplier);
        Garages garages = new Garages(2,"Zapupkino", 228);
        GarageDAO garagesDAO = new GarageDAO();
        int id = 1;
        //garagesDAO.save(garages);
        garagesDAO.findById(id);
    }

}
