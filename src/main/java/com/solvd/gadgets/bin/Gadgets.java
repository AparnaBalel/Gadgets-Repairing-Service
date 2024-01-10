package com.solvd.gadgets.bin;

import java.util.Date;

public class Gadgets {
    private long  gadgetID;
    private String gadgetName;
    private String  brand;
    private String model;
    private Date purchaseDate;
     private long customerID;

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public Gadgets() {
    }

    public Gadgets(long gadgetID, String gadgetName, String brand, String model, Date purchaseDate, long customerID) {
        this.gadgetID = gadgetID;
        this.gadgetName = gadgetName;
        this.brand = brand;
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.customerID = customerID;
    }

    public long getGadgetID() {
        return gadgetID;
    }

    public void setGadgetID(long gadgetID) {
        this.gadgetID = gadgetID;
    }

    public String getGadgetName() {
        return gadgetName;
    }

    public void setGadgetName(String gadgetName) {
        this.gadgetName = gadgetName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
