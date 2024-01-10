package com.solvd.gadgets;

import com.solvd.gadgets.bin.Technicians;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;

import java.io.IOException;

public class DomParser {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(JdbcConnection.class);

    public static void main(String[] args) {
            // DOM
        File file = new File("src/main/resources/company.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder  =  factory.newDocumentBuilder();
           Document document =  builder.parse(file);
           document.getChildNodes();
        } catch (ParserConfigurationException | IOException |SAXException e) {
            throw new RuntimeException(e);
        }

        // SAX
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxFactory.newSAXParser();
            parser.parse(file,new SaxHandler());
        } catch (ParserConfigurationException | SAXException |IOException e) {
            throw new RuntimeException(e);
        }

            //StAX
   /*     XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try (FileInputStream fis = new FileInputStream(file)){
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(fis);
            while (reader.hasNext()){
                XMLEvent event = reader.nextEvent();
                event.asStartElement();
            }
        } catch (IOException | XMLStreamException e) {
            throw new RuntimeException(e);
        }*/

        // JAXB
        try {
            JAXBContext context = JAXBContext.newInstance(Technicians.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Technicians technicians = (Technicians)  unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }


    }
}
