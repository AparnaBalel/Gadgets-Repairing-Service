package com.solvd.gadgets.service.jdbc;

import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.CustomerDAO;
import com.solvd.gadgets.dao.impl.jdbc.CustomerDAOImpl;
import com.solvd.gadgets.service.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = Logger.getLogger(CustomerServiceImpl.class.getName());

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

            if (customerDAO.isEmailAlreadyExists(Email)) {
                throw new IllegalArgumentException("A customer with the same email already exists.");
            }
            Customer newCustomer = new Customer();
            newCustomer.setFirstName(firstName);
            newCustomer.setLastName(lastName);
            newCustomer.setEmail(Email);
            newCustomer.setPhone(Phone);
            customerDAO.create(newCustomer);
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
        return null;
    }

    @Override
    public void updateCustomer(int customerId) {

    }

    @Override
    public void deleteCustomer(int customerId) {

    }

    @Override
    public void createAndInsertCustomer(String customerName) {

    }
}
