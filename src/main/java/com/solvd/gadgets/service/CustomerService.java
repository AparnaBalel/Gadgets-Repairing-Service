package com.solvd.gadgets.service;

import com.solvd.gadgets.bin.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

        void insertCustomer(String firstName, String lastName, String Email, long Phone);

        Optional<Customer> getCustomerById(int customerId);

        List<Customer> getAllCustomers();

        void updateCustomer(int customerId);

        void deleteCustomer(int customerId);

        void createAndInsertCustomer(String customerName);
    }

