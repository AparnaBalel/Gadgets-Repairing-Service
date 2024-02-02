package com.solvd.gadgets.bin;

import java.util.List;

public class Customer {
    private long customerID;
    private String firstName;
    private String lastName;
    private long phone;
    private String email;
    private List<Customer> customerList;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Customer() {
    }
    public Customer(long customerID, String firstName, String lastName, long phoneNumber, String email) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhone() {
        return this.phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailId) {
        this.email = emailId;
    }

    @Override
    public String toString() {
        return "Customer:" + "\n" +
                 customerID + "\n" + firstName + " " + lastName + "\n" +
                 phone + "\n" + email;
    }
}
