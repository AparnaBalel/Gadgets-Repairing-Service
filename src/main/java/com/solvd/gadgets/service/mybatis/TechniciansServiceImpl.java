package com.solvd.gadgets.service.mybatis;

import com.solvd.gadgets.bin.Technicians;
import com.solvd.gadgets.dao.impl.jdbc.TechniciansDAOImpl;
import com.solvd.gadgets.service.serviceInterfaces.TechniciansService;
import com.solvd.gadgets.util.DomParser;

import java.io.File;
import java.util.logging.Logger;

public class TechniciansServiceImpl implements TechniciansService {
    private static final Logger LOGGER = Logger.getLogger(com.solvd.gadgets.service.jdbc.TechniciansServiceImpl.class.getName());

    private TechniciansDAOImpl techniciansDAO;

    public TechniciansServiceImpl(TechniciansDAOImpl techniciansDAO) {
        this.techniciansDAO = techniciansDAO;
    }
    File file = new File("src/main/resources/company.xml");
    String tagName = "technician";
    @Override
    public void insertTechnician(String firstName, String lastName, String Email, long Phone) {
        Technicians technician = new Technicians();
        technician.setFirstName(firstName);
        technician.setLastName(lastName);
        technician.setEmail(Email);
        technician.setPhoneNumber(Phone);
        techniciansDAO.create(technician);
        LOGGER.info("Technician ID: " + technician.getTechnicianID());
        LOGGER.info("First Name: " + technician.getFirstName());
        LOGGER.info("Last Name: " + technician.getLastName());
        LOGGER.info("Email: " + technician.getEmail());
        LOGGER.info("Phone: " + technician.getPhoneNumber());
    }

    @Override
    public void deleteByID(int technicianID) {
        techniciansDAO.deleteByID(technicianID);

    }

    @Override
    public void parsingTechnician() {
        DomParser domParser = new DomParser();
        domParser.DomParsing(file,tagName);
    }
}
