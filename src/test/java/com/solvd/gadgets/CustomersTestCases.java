package com.solvd.gadgets;

import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.daoInterfaces.CustomerDAO;
import com.solvd.gadgets.dao.impl.myBatis.CustomerDAOImpl;
import com.solvd.gadgets.service.jdbc.CustomerServiceImpl;
import com.solvd.gadgets.service.serviceInterfaces.CustomerService;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CustomersTestCases {
    private static final Logger LOGGER = Logger.getLogger(CustomersTestCases.class.getName());
 SoftAssert softAssert = new SoftAssert();
    CustomerDAO customerDao = new CustomerDAOImpl();
    CustomerService customerService = new CustomerServiceImpl(customerDao);
    @Test (priority = 1)
    public void CreateNewCustomerTest() {
         customerService.insertCustomer("Naia", "Bisht", "naia.bisht@example.com", 2727272727l);
        Optional<Customer> customer = customerService.getCustomerById(34);
        assertEquals(customer.get().getFirstName(), "Naia");
        assertEquals(customer.get().getLastName(), "Bisht");
        assertEquals(customer.get().getEmail(), "naia.bisht@example.com");
        assertEquals(customer.get().getPhone(), 2727272727l);

    }

    @Test (priority = 2)
    public void GetCustomerByIDTest() {
        customerService.insertCustomer("John", "Doe", "john.doe@example.com", 1234567890);
        Optional<Customer> customer = customerService.getCustomerById(23);
        assertTrue(customer.isPresent());
        assertEquals(customer.get().getFirstName(), "John");
        assertEquals(customer.get().getLastName(), "Doe");
        assertEquals(customer.get().getEmail(), "john.doe@example.com");
        assertEquals(customer.get().getPhone(), 1234567890);
    }

    @Test (priority = 3)
    public void UpdateCustomerTest() {

    }

    @Test (priority = 4)
    public void DeleteCustomerTest() {

    }

    @Test (priority = 5)
    public void GetAllCustomersTest() {

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void NumbersInFirstNameTest() {
        softAssert.fail("first name contain numbers");

        customerService.insertCustomer("John123", "Doe", "john.doe@example.com", 1234567890);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void NumbersInLastNameTest() {
        customerService.insertCustomer("John", "Doe123", "john.doe@example.com", 1234567890);
        softAssert.fail("last name contain numbers");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void InvalidEmailFormatTest() {
        customerService.insertCustomer("John", "Doe", "invalid-email", 1234567890);
        softAssert.fail("invalid email");
        softAssert.assertAll();
    }

}
