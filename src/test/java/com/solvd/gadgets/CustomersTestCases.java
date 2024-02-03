package com.solvd.gadgets;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.logging.Logger;

public class CustomersTestCases {
    private static final Logger LOGGER = Logger.getLogger(CustomersTestCases.class.getName());



    @Test (priority = 1)
    public void CreateNewCustomerTest() {
        String firstName = null, lastName = "Doe", email = "john.doe@example.com";
        long phone = 1234567890L;

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(firstName, "First name is null");
        softAssert.assertNotNull(lastName, "Last name is null");
        softAssert.assertNotNull(email, "Email is null");
        softAssert.assertNotNull(phone, "Phone number is null");
        softAssert.assertAll();
    }

    @Test (priority = 2)
    public void NumbersInFirstNameTest() {
            String firstName = "John111";
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(firstName.matches(".*\\d.*"), "Numbers should not be allowed in the first name field");
            softAssert.assertAll();
        }

    @Test (priority = 3)
    public void NumbersInLastNameTest( ) {
            String lastName = "Doe123";
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(lastName.matches(".*\\d.*"), "Numbers should not be allowed in the last name field");
            softAssert.assertAll();
        }


    @Test (priority = 4)
    public void InvalidEmailFormatTest() {
        String email = "invalid-email";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(email.contains( "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +  "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"), "invalid email format");
        softAssert.assertAll();
    }
    @Test (priority = 5)
    public void InvalidPhoneTest(String firstName, String lastName, String Email, long Phone) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(String.valueOf(Phone).matches("^\\d{10}$"), "invalid phone number: " + Phone);
        softAssert.assertAll();
    }


    @Test (priority = 6)
    public void GetCustomerByIDTest() {
        String firstName = "Aaa", lastName = "Bbb", email = "aaa_BBB@example.com";
        long phone = 1234567891;

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(firstName, "Aaa", "First name mismatch");
        softAssert.assertEquals(lastName, "Bbb", "Last name mismatch");
        softAssert.assertEquals(email, "aaa_BBB@example.com", "Email mismatch");
        softAssert.assertEquals(phone, 1234567891, "Phone number mismatch");
        softAssert.assertAll();
    }

    @Test (priority = 7)
    public void UpdateCustomerTest() {

    }

   @Test (priority = 8)
    public void DeleteCustomerTest() {

    }

    @Test (priority = 9)
    public void GetAllCustomersTest() {

    }






}
