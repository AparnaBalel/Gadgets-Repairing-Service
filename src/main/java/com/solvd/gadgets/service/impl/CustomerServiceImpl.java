package com.solvd.gadgets.service.impl;

import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.CustomerDao;
import com.solvd.gadgets.dao.impl.CustomerDaoImpl;
import com.solvd.gadgets.service.CustomerService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class.getName());

    private CustomerDaoImpl customerDAO;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDAO = new CustomerDaoImpl();
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

            if (customerDAO.isEmailAlreadyExists(Email)) {
                throw new IllegalArgumentException("A customer with the same email already exists.");
            }
            Customer newCustomer = new Customer();
            newCustomer.setFirstName(firstName);
            newCustomer.setLastName(lastName);
            newCustomer.setEmail(Email);
            newCustomer.setPhone(Phone);
            customerDAO.insert(newCustomer);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error adding customer: " + e.getMessage(), e);
            throw new RuntimeException("Error adding customer. Please try again later.");
        }
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public void updateCustomer(int customerId, String newCustomerName) {

    }

    @Override
    public void deleteCustomer(int customerId) {

    }

    @Override
    public void createAndInsertCustomer(String customerName) {

    }
}
