package com.solvd.gadgets.service;

import com.solvd.gadgets.bin.Customer;

import java.util.List;

public interface CustomerService {

        void insertCustomer(String firstName, String lastName, String Email, long Phone);
        Customer getCustomerById(int customerId);

        List<Customer> getAllCustomers();

        void updateCustomer(int customerId, String newCustomerName);

        void deleteCustomer(int customerId);

        void createAndInsertCustomer(String customerName);
    }

