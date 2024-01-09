package com.solvd.gadgets_Repairing_Service.service;

import com.solvd.gadgets_Repairing_Service.bin.Customer;

import java.util.List;

public interface CustomerService {

        void insertCustomer(String firstName, String lastName, String Email, long Phone);
        Customer getCustomerById(int customerId);

        List<Customer> getAllCustomers();

        void updateCustomer(int customerId, String newCustomerName);

        void deleteCustomer(int customerId);

        void createAndInsertCustomer(String customerName);
    }

