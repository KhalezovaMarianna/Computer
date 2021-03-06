package com.solvd.dataBase.parser.dom;

import com.solvd.dataBase.parser.models.*;
import com.solvd.exceptions.ProcessorException;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DomParser {
    private static final Logger LOGGER = LogManager.getLogger(DomParser.class);

    private ActiveTasks activeTasks = new ActiveTasks();

    public void parse() throws ParserConfigurationException, IOException, SAXException, ProcessorException, ParseException {


        Task task = new Task();
        Admins admins = new Admins();
        Employeers employeers = new Employeers();
        List<Employeers> employeerList = new ArrayList<>();
        List<Task> taskList = new ArrayList<>();
        List<Services> service = new ArrayList<>();
        Clients clients = new Clients();

        File xmlFile = new File(System.getProperty("user.dir") + "/src/main/resources/service.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        Element element = doc.getDocumentElement();
        activeTasks.setId(Integer.parseInt(element.getAttribute("id")));
        activeTasks.setName(element.getElementsByTagName("name").item(0).getTextContent());
        activeTasks.setAddress(element.getElementsByTagName("address").item(0).getTextContent());
        NodeList nodeList = doc.getElementsByTagName("admins");
        employeers.setAdmins(admins);
        Node adminsNode = nodeList.item(0);
        Element element1 = (Element) adminsNode;
        admins.setName(element1.getElementsByTagName("name").item(0).getTextContent());
        admins.setFirstName(element1.getElementsByTagName("firstName").item(0).getTextContent());

        admins.setTelefonNumber(element1.getElementsByTagName("telefonNumber").item(0).getTextContent());
        employeers.setAdmins(admins);
        employeerList.add(employeers);
        activeTasks.setEmployeers(employeerList);
        nodeList = doc.getElementsByTagName("services");


        for (int i = 0; i < nodeList.getLength(); i++) {
            Services services = new Services();
            Node node = nodeList.item(i);
            Element el = (Element) node;
            services.setTimeToWork(Double.parseDouble(el.getElementsByTagName("timeToWork").item(0).getTextContent()));
            services.setService(el.getElementsByTagName("service").item(0).getTextContent());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            services.setDateOfChange(sdf.parse(el.getElementsByTagName("dateOfChange").item(0).getTextContent()));
            service.add(services);
            task.setServices(service);

        }
        NodeList clientsList = doc.getElementsByTagName("clients");
        Node clientNode = clientsList.item(0);
        Element clientElement = (Element) clientNode;
        clients.setFirstName(clientElement.getElementsByTagName("firstName").item(0).getTextContent());
        clients.setName(clientElement.getElementsByTagName("name").item(0).getTextContent());

        taskList.add(task);
        activeTasks.setTask(taskList);

        LOGGER.info(activeTasks);
    }

    public ActiveTasks takeActiveTasks() {
        return activeTasks;
    }
}