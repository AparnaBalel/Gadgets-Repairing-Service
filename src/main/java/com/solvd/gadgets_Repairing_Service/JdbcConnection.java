package com.solvd.gadgets_Repairing_Service;

import com.solvd.gadgets_Repairing_Service.bin.Customer;
import com.solvd.gadgets_Repairing_Service.dao.CustomerDao;
import com.solvd.gadgets_Repairing_Service.dao.impl.CustomerDaoImpl;
import com.solvd.gadgets_Repairing_Service.service.CustomerService;
import com.solvd.gadgets_Repairing_Service.service.impl.CustomerServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class JdbcConnection {
    private static final Logger LOGGER = LogManager.getLogger(JdbcConnection.class);

            public static void main(String[] args) {
                CustomerDao customerDao = new CustomerDaoImpl();

                // Create a CustomerService instance
                CustomerService customerService = new CustomerServiceImpl(customerDao);

                // Adding a customer
                customerService.insertCustomer("John", "Doe", "john.doe@example.com", 1234567890L);

                // Checking if an email already exists
                String existingEmail = "john.doe@example.com";
                if (customerDao.isEmailAlreadyExists(existingEmail)) {
                    System.out.println("Email " + existingEmail + " already exists in the database.");
                } else {
                    System.out.println("Email " + existingEmail + " does not exist in the database.");
                }

                // Retrieving a customer by email
                String searchEmail = "john.doe@example.com";
                Customer foundCustomer = customerDao.getCustomerByEmail(searchEmail);
                if (foundCustomer != null) {
                    System.out.println("Customer found: " + foundCustomer.getFirstName() + " " + foundCustomer.getLastName());
                } else {
                    System.out.println("Customer not found with email: " + searchEmail);
                }

                Customer newCustomer = new Customer();
                newCustomer.setFirstName("eden");
                newCustomer.setLastName("dan");
                newCustomer.setPhone(123045607);
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

