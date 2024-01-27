package com.solvd.gadgets;

import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.CustomerDAO;
import com.solvd.gadgets.dao.impl.jdbc.CustomerDAOImpl;
import com.solvd.gadgets.service.CustomerService;
import com.solvd.gadgets.service.jdbc.CustomerServiceImpl;
import com.solvd.gadgets.service.jdbc.TechniciansServiceImpl;
import com.solvd.gadgets.service.mybatis.PartsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        CustomerDAO customerDao = new CustomerDAOImpl();
        CustomerService customerService = new CustomerServiceImpl(customerDao);
        customerService.insertCustomer("John", "Doe", "john.doe@example.com", 1234567890L);

        String existingEmail = "john.doe@example.com";
        if (customerDao.isEmailAlreadyExists(existingEmail)) {
            LOGGER.info("Email " + existingEmail + " already exists in the database.");
        } else {
            LOGGER.info("Email " + existingEmail + " does not exist in the database.");
        }

        String searchEmail = "john.doe@example.com";
        Customer foundCustomer = customerDao.getCustomerByEmail(searchEmail);
        if (foundCustomer != null) {
            LOGGER.info("Customer found: " + foundCustomer.getFirstName() + " " + foundCustomer.getLastName());
        } else {
            LOGGER.info("Customer not found with email: " + searchEmail);
        }

        customerDao.getById(1);
        TechniciansServiceImpl technician = new TechniciansServiceImpl();
        technician.parsingTechnician();

        PartsServiceImpl partsService = new PartsServiceImpl();
        partsService.parsingParts();
    }

}
