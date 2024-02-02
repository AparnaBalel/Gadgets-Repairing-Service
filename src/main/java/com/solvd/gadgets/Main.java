package com.solvd.gadgets;

import com.solvd.gadgets.dao.daoInterfaces.CustomerDAO;
import com.solvd.gadgets.dao.impl.jdbc.TechniciansDAOImpl;
import com.solvd.gadgets.dao.impl.myBatis.CustomerDAOImpl;

import com.solvd.gadgets.dao.impl.myBatis.PartsDAOImpl;
import com.solvd.gadgets.service.jdbc.TechniciansServiceImpl;
import com.solvd.gadgets.service.serviceInterfaces.CustomerService;
import com.solvd.gadgets.service.serviceInterfaces.PartsService;
import com.solvd.gadgets.service.jdbc.CustomerServiceImpl;
import com.solvd.gadgets.service.mybatis.PartsServiceImpl;
import com.solvd.gadgets.service.serviceInterfaces.TechniciansService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        TechniciansDAOImpl techniciansDAO = new TechniciansDAOImpl();
        TechniciansService technician = new TechniciansServiceImpl(techniciansDAO);
        PartsDAOImpl partsDAO = new PartsDAOImpl();
        PartsService partsService = new PartsServiceImpl(partsDAO);
        CustomerDAO customerDao = new CustomerDAOImpl();
        CustomerService customerService = new CustomerServiceImpl(customerDao);
       // customerService.insertCustomer("Jonathan", "Doe", "johnathan.doe@example.com", 1234567890L);

        customerService.getAllCustomers();


        LOGGER.info( customerService.getCustomerById(6));

        technician.parsingTechnician();

       partsService.parsingParts();

    }

}
