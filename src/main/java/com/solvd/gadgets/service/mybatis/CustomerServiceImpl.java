package com.solvd.gadgets.service.mybatis;

import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.impl.jdbc.CustomerDAOImpl;
import com.solvd.gadgets.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDAOImpl customerDAO;

    public CustomerServiceImpl(SqlSession sqlSession) {
        this.customerDAO = new CustomerDAOImpl(sqlSession);
    }
    @Override
    public void insertCustomer(String firstName, String lastName, String Email, long Phone) {

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
