package com.solvd.gadgets;

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
        TechniciansService technician = new TechniciansServiceImpl();
        PartsService partsService = new PartsServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        customerService.insertCustomer("Jonathan", "doe", "johnathan.doe@example.com", 1234567890L);

        customerService.getAllCustomers();

        LOGGER.info( customerService.getCustomerById(6));

        technician.parsingTechnician();

       partsService.parsingParts();

    }

}
