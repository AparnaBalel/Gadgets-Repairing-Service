package com.solvd.gadgets.util;

import com.solvd.gadgets.JdbcConnection;
import com.solvd.gadgets.bin.Technicians;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

public class JAXBParser {
    private static final Logger LOGGER = LogManager.getLogger(JAXBParser.class);

    public void JAXBParser(){

        File file = new File("src/main/resources/company.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(Technicians.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Technicians technicians = (Technicians)  unmarshaller.unmarshal(file);
            List<Technicians> technicianList = technicians.getTechnicianList();

            // Iterate through technicians
            for (Technicians technician : technicianList) {
                // Print technician details
                LOGGER.info("Technician ID: " + technician.getTechnicianID());
                LOGGER.info("First Name: " + technician.getFirstName());
                LOGGER.info("Last Name: " + technician.getLastName());
                LOGGER.info("Email: " + technician.getEmail());
                LOGGER.info("Phone: " + technician.getPhoneNumber());
                LOGGER.info("--------------------------");
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        }
    }
