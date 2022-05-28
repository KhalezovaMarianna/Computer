package com.solvd.parser.jaxb;

import com.solvd.parser.models.Services;
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

    public static void marshal(Services services) {
        try {
            JAXBContext context = JAXBContext.newInstance(Services.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(services, new File(System.getProperty("user.dir") + "/src/main/resources/serviceJaxb.xml"));
        } catch (JAXBException e){
            LOGGER.info(e);
        }
    }
    public static Services unmarhall() throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(Services.class);
        return (Services) context.createUnmarshaller()
                .unmarshal(new FileReader(System.getProperty("user.dir") + "/src/main/resources/serviceJaxb.xml"));
    }
}

