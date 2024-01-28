package com.solvd.gadgets.service.mybatis;

import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.impl.jdbc.CustomerDAOImpl;
import com.solvd.gadgets.service.CustomerService;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAOImpl customerDAO;

    public CustomerServiceImpl() {
        this.customerDAO = new CustomerDAOImpl();
    }
    @Override
    public void insertCustomer(String firstName, String lastName, String Email, long Phone) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(firstName);
        newCustomer.setLastName(lastName);
        newCustomer.setEmail(Email);
        newCustomer.setPhone(Phone);
        customerDAO.create( newCustomer);
    }

    @Override
    public Optional<Customer> getCustomerById(int customerId) {
        return null;
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
