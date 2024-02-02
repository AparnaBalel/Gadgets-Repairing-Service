package com.solvd.gadgets.util;

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
                LOGGER.info("\n" + "Technician ID: " + " " +technician.getTechnicianID() +"\n"
                + "Technician Name: " + technician.getFirstName() + technician.getLastName() +"\n"
                + "Email: " + technician.getEmail() +"\n"
                + "Phone: " + technician.getPhoneNumber() +"\n ");
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        }
    }
