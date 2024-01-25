package com.solvd.gadgets.dao;

import com.solvd.gadgets.bin.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {
    Optional<Customer> getById(long customerId) ;
    void create(Customer customer);
    void update( Customer customerId);
    void deleteById(long customerId);
    List<Customer> getAllCustomer();

    boolean isEmailAlreadyExists(String Email);
    Customer getCustomerByEmail(String Email);


}
