package com.solvd.gadgets;

import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.CustomerDAO;
import com.solvd.gadgets.dao.impl.jdbc.CustomerDAOImpl;
import com.solvd.gadgets.service.CustomerService;
import com.solvd.gadgets.service.jdbc.CustomerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class JdbcConnection {
    private static final Logger LOGGER = LogManager.getLogger(JdbcConnection.class);

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

                Customer newCustomer = new Customer();
                newCustomer.setFirstName("eden");
                newCustomer.setLastName("dan");
                newCustomer.setPhone(123045607);
                newCustomer.setEmail("Nahushjacon@email.com");

                LOGGER.info("New Customer Details:");
                LOGGER.info("Customer ID: " + newCustomer.getCustomerID());
                LOGGER.info("Customer Name: " + newCustomer.getFirstName());

                CustomerDAO customerDAO = new CustomerDAOImpl();
                customerDAO.create (newCustomer);

               LOGGER.info( customerDAO.getById(1));

                Customer updateCustomer = new Customer();
                updateCustomer.setCustomerID(1);
                updateCustomer.setFirstName("Tammy");

                customerDAO.update(updateCustomer);

                LOGGER.info(updateCustomer);

            }
        }

