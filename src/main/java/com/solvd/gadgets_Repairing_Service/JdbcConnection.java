package com.solvd.gadgets_Repairing_Service;

import com.solvd.gadgets_Repairing_Service.bin.Customer;
import com.solvd.gadgets_Repairing_Service.dao.CustomerDao;
import com.solvd.gadgets_Repairing_Service.dao.impl.CustomerDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

            public static void main(String[] args) {

                Customer newCustomer = new Customer();
                newCustomer.setFirstName("eden");
                newCustomer.setLastName("dan");
                newCustomer.setPhone(0123045607);
                newCustomer.setEmail("Nahushjacon@email.com");

                LOGGER.info("New Customer Details:");
                LOGGER.info("Customer ID: " + newCustomer.getCustomerID());
                LOGGER.info("Customer Name: " + newCustomer.getFirstName());

                CustomerDao customerDAO = new CustomerDaoImpl();
                customerDAO.insert (newCustomer);

               LOGGER.info( customerDAO.getById(1));

                Customer updateCustomer = new Customer();
                updateCustomer.setCustomerID(1);
                updateCustomer.setFirstName("Tammy");

                customerDAO.update(updateCustomer);

                LOGGER.info(updateCustomer);


            }
        }

