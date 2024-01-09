package com.solvd.gadgets_Repairing_Service.dao;

import com.solvd.gadgets_Repairing_Service.bin.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    Optional<Customer> getById(long customerId) ;
    Optional<Customer> getByName(String lastName) ;
    void insert(Customer customer);
    void update( Customer customerId);

    void deleteById(Long customerId);
    List<Customer> getAllCustomer();

    boolean isEmailAlreadyExists(String Email);
    Customer getCustomerByEmail(String Email);
}
