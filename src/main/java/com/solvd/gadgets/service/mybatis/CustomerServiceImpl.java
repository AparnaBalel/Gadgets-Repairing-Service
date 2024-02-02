package com.solvd.gadgets.service.mybatis;

import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.daoInterfaces.CustomerDAO;
import com.solvd.gadgets.dao.impl.myBatis.CustomerDAOImpl;
import com.solvd.gadgets.service.serviceInterfaces.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerServiceImpl implements CustomerService {
    private static final Logger LOGGER = Logger.getLogger(com.solvd.gadgets.service.jdbc.CustomerServiceImpl.class.getName());

    private CustomerDAOImpl customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDao) {

        this.customerDAO = new CustomerDAOImpl();
    }
    @Override
    public void insertCustomer(String firstName, String lastName, String Email, long Phone) {
        try {
            if (firstName != null && firstName.matches(".*\\d.*")) {
                throw new IllegalArgumentException("First name cannot contain numbers.");
            }

            if (lastName != null && lastName.matches(".*\\d.*")) {
                throw new IllegalArgumentException("Last name cannot contain numbers.");
            }

            if (Email == null || !Email.contains("@") || !Email.endsWith(".com")) {
                throw new IllegalArgumentException("Invalid customer email format.");
            }

            if (String.valueOf(Phone).length() != 10) {
                throw new IllegalArgumentException("Invalid customer phone number. It should be exactly 10 digits.");
            }

            Customer newCustomer = new Customer();
            newCustomer.setFirstName(firstName);
            newCustomer.setLastName(lastName);
            newCustomer.setEmail(Email);
            newCustomer.setPhone(Phone);
            customerDAO.create(newCustomer);
            LOGGER.info("New Customer Details:");
            LOGGER.info("Customer ID: " + newCustomer.getCustomerID());
            LOGGER.info("Customer Name: " + newCustomer.getFirstName());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error adding customer: " + e.getMessage(), e);
            throw new RuntimeException("Error adding customer. Please try again later.");
        }
    }

    @Override
    public Optional<Customer> getCustomerById(int customerId) {

        return customerDAO.getById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerDAO.getAllCustomer();
    }
    @Override
    public void updateCustomer(int customerId) {
           customerDAO.update(customerId);
    }

    @Override
    public void deleteCustomer(int customerId) {
        customerDAO.deleteById(customerId);

    }

}
