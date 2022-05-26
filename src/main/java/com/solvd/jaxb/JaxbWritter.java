package com.solvd.jaxb;

import com.solvd.classes.*;
import com.solvd.parser.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxbWritter {
    private static final Logger LOGGER = LogManager.getLogger(JaxbWritter.class);
    public static void marshal(){
    Masters masters = new Masters();
    masters.setName("Misha");
    masters.setFirstName("Stechnovich");
    masters.setTelefonNumber("+375243254343");

        Autos auto = new Autos();
        auto.setModel("renaut");
        auto.setStateNumber(7658);

        Garages garage  = new Garages();
        garage.setAdress("Rucha Street 5");
        garage.setMaxWorkers(56);

        Clients clients = new Clients();
        clients.setName("Anna");
        clients.setFirstName("Kurako");
        clients.setTelefonNumber("+375446890987");
        clients.setAuto(auto.setModel("citroen"));

        Suppliers suppliers= new Suppliers();
        suppliers.setCountry("Belarus");
        suppliers.setModel("Geely");
        Services services = new Services();
        services.setService("Change oil");
        services.setTimeToWork(services.getTimeToWork(4.30));
        try {
            JAXBContext context = JAXBContext.newInstance(Services.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(services,new File(System.getProperty("user.dir")+"/src/main/resources/service.xml"));
        } catch (JAXBException e) {
            LOGGER.info(e);
        }
    }
    public static  Services unmarshal() throws JAXBException, FileNotFoundException{
        JAXBContext jaxbContext = JAXBContext.newInstance(Services.class);
        return (Services) jaxbContext.createUnmarshaller().unmarshal(new FileReader(System.getProperty("user.dir")+"/src/main/resources/service.xml"));

    }
}
