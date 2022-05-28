package com.solvd.parser.dom;

import com.solvd.serviceStation.classes.Garages;
import com.solvd.serviceStation.classes.Masters;
import com.solvd.serviceStation.classes.Suppliers;
import com.solvd.exceptions.ProcessorException;
import com.solvd.parser.models.Clients;
import com.solvd.parser.models.Services;
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
import java.util.ArrayList;
import java.util.List;

public class DomParser {
    private static final Logger LOGGER = LogManager.getLogger(DomParser.class);

    Services services = new Services();
    Masters masters = new Masters();
    Garages garage = new Garages();
    Clients clients = new Clients();

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Masters getMasters() {
        return masters;
    }

    public void setMasters(Masters masters) {
        this.masters = masters;
    }

    public Garages getGarage() {
        return garage;
    }

    public void setGarage(Garages garage) {
        this.garage = garage;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public void parse() throws ParserConfigurationException, IOException, SAXException, ProcessorException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document doc = builder.parse(new File(System.getProperty("user.dir") + "/src/main/resources/service.xml"));
        NodeList nodeList = doc.getElementsByTagName("service");
        nodeList.getLength();
        Node node = nodeList.item(0);
        Element element = (Element) node;
        masters.setName(element.getElementsByTagName("name").item(0).getTextContent());
        masters.setFirstName(element.getElementsByTagName("firstName").item(0).getTextContent());
        masters.setTelefonNumber(element.getElementsByTagName("telefonNumber").item(0).getTextContent());
        Element garageElement = (Element) node;
        garage.setMaxWorkers(Integer.parseInt(garageElement.getElementsByTagName("maxWorkers").item(0).getTextContent()));
        garage.setAdress(garageElement.getElementsByTagName("adress").item(0).getTextContent());
        Element clientsElement = (Element) node;
        clients.setFirstName(clientsElement.getElementsByTagName("firstName").item(0).getTextContent());
        clients.setName(clientsElement.getElementsByTagName("name").item(0).getTextContent());
        clients.setTelefonNumber(clientsElement.getElementsByTagName("telefonNumber").item(0).getTextContent());


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
        LOGGER.info(services);
    }
    public Services takeServices(){
        return services;
    }
}
