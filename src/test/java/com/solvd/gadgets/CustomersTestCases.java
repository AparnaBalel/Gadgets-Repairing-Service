package com.solvd.gadgets;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.logging.Logger;

public class CustomersTestCases {
    private static final Logger LOGGER = Logger.getLogger(CustomersTestCases.class.getName());
    SoftAssert softAssert = new SoftAssert();
    private ArrayList<Customer> customers = new ArrayList<>();

    {
        customers.add(new Customer("john", "Doe", "john.doe@example.com", 1234567890L));
        customers.add(new Customer("Jane", "Smith", "jane.smith@example.com", 1234567890L));
        customers.add(new Customer("AAA", "BBB", "AAA.BBB@example.com", 1234567890L));
    }
    @Test (priority = 1, description = "create new customer")
    public void CreateNewCustomerTest_01() {
        customers.add(new Customer("cccc", "ddd", "cccc.ddd@example.com", 1234567891L));
        customers.stream()
                 .skip(customers.size() - 1)
                 .forEach(customer -> {
                    softAssert.assertEquals(customer.getFirstName(), "cccc", "First name mismatch");
                    softAssert.assertEquals(customer.getLastName(), "ddd", "Last name mismatch");
                    softAssert.assertEquals(customer.getEmail(), "cccc.ddd@example.com", "Email mismatch");
                    softAssert.assertEquals(customer.getPhone(), 1234567891, "Phone number mismatch");
                     softAssert.assertAll();
                 });
        LOGGER.info("\n" + "new customer added successfully");
    }

    @Test (priority = 2 ,description = "Numbers In First Name field ")
    public void NumbersInFirstNameTest_02() {
        customers.stream().map(Customer::getFirstName)
                .forEach(firstName -> softAssert.assertFalse(firstName.matches(".*\\d.*"),
                        "Numbers should not be allowed in the first name field" + ":" + firstName));
        softAssert.assertAll();
        LOGGER.info("\n" + "no numbers in fist name ");
        }

    @Test (priority = 3 ,description = "Numbers In Last Name field ")
    public void NumbersInLastNameTest_03( ) {
        customers.stream().map(Customer::getLastName)
                .forEach(lastName -> softAssert.assertFalse(lastName.contains(".*\\d.*"),
                        "Numbers should not be allowed in the last name field"+ ":" + lastName));
            softAssert.assertAll();
        LOGGER.info("\n" + "no numbers in last name ");
        }


    @Test (priority = 4, description = "valid email format")
    public void InvalidEmailFormatTest_04() {
        customers.stream().map(Customer::getEmail)
                .forEach(email -> softAssert.assertTrue(email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"),
                        "Invalid email format: " + email));
        softAssert.assertAll();
        LOGGER.info("\n" + "All emails are valid");
    }
    @Test (priority = 5 ,description = "10 digit phone number")
    public void InvalidPhoneTest_05( ){
        customers.stream()
                .map(Customer::getPhone)
                .forEach(phone -> softAssert.assertTrue(String.valueOf(phone).matches("^\\d{10}$"),
                        "Invalid phone number: " + phone));
        softAssert.assertAll();
        LOGGER.info("\n" + "All phone numbers are 10 digit");
    }

    @Test (priority = 6 ,description = "get customer by index")
    public void GetCustomerByIDTest_06() {
        Customer customer = customers.get(0);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(customer.firstName, "john", "First name mismatch");
        softAssert.assertEquals(customer.lastName, "Doe", "Last name mismatch");
        softAssert.assertEquals(customer.email, "john.doe@example.com", "Email mismatch");
        softAssert.assertEquals(customer.phone, 1234567890L, "Phone number mismatch");
        softAssert.assertAll();
        LOGGER.info("\n" + "able to get customer successfully");
    }

    @Test (priority = 7 ,description = "update customers detail")
    public void UpdateCustomerTest_07() {
           Customer updateCustomer = customers.get(2);
           updateCustomer.setLastName("ccc");
           softAssert.assertEquals( updateCustomer.getLastName(), "ccc", "lastName updated" );
           softAssert.assertAll();
           LOGGER.info("\n" + "able to update customer successfully");
    }

   @Test (priority = 8 ,description = "delete customer detail")
    public void DeleteCustomerTest_08() {
           int actualSize = customers.size();
           Customer deleteCustomer = customers.remove(customers.size()-1);
           int expectedSize = customers.size();
           softAssert.assertNotEquals(actualSize,expectedSize, "customer deleted successfully"+ actualSize +" " + expectedSize);
           System.out.println("actual size: " + actualSize +" \n" + "expected size: " + expectedSize);
           softAssert.assertAll();
           LOGGER.info("\n" + "able to delete customer successfully");
    }

    @Test (priority = 9 ,description = "get all customer")
    public void GetAllCustomersTest_09() {
        customers.stream()
                .forEach(customer -> {
                    LOGGER.info("\n" + "Customer Details:" + "\n"
                            + "First Name: " + customer.getFirstName() + "\n"
                            + "Last Name: " + customer.getLastName() + "\n"
                            + "Email: " + customer.getEmail() + "\n"
                            + "Phone: " + customer.getPhone() + "\n"
                            + "---------------");
                });
    }






}
