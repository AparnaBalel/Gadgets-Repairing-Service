package com.solvd.gadgets.bin;

public class ServicePrices {
    private long servicePriceID;
    private long serviceTypeID;
    private double Price;
    public ServicePrices() {
    }
    public ServicePrices(long servicePriceID, long serviceTypeID, double price) {
        this.servicePriceID = servicePriceID;
        this.serviceTypeID = serviceTypeID;
        Price = price;
    }
    public long getServicePriceID() {
        return servicePriceID;
    }
    public void setServicePriceID(long servicePriceID) {
        this.servicePriceID = servicePriceID;
    }
    public long getServiceTypeID() {
        return serviceTypeID;
    }
    public void setServiceTypeID(long serviceTypeID) {
        this.serviceTypeID = serviceTypeID;
    }
    public double getPrice() {
        return Price;
    }
    public void setPrice(double price) {
        Price = price;
    }
    @Override
    public String toString() {
        return "ServicePrices{" +
                "servicePriceID=" + servicePriceID +
                ", serviceTypeID=" + serviceTypeID +
                ", Price=" + Price +
                '}';
    }
}
