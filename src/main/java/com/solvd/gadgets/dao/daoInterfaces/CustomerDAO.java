package com.solvd.gadgets.dao.daoInterfaces;

import com.solvd.gadgets.bin.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {
    Optional<Customer> getById(int customerId) ;
    void create(@Param("customer")Customer customer);
    void update( int customerId);
    void deleteById(int customerId);
    List<Customer> getAllCustomer();




}
