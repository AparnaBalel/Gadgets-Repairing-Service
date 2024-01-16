package com.solvd.gadgets.util;

import com.solvd.gadgets.bin.Technicians;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

public class JAXBParser {

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
                System.out.println("Technician ID: " + technician.getTechnicianID());
                System.out.println("First Name: " + technician.getFirstName());
                System.out.println("Last Name: " + technician.getLastName());
                System.out.println("Email: " + technician.getEmail());
                System.out.println("Phone: " + technician.getPhoneNumber());
                System.out.println("--------------------------");
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        }
    }
