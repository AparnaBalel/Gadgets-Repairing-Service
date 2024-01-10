package com.solvd.gadgets.bin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.gadgets.MyAdapter;
import com.solvd.gadgets.SecondAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;

public class Payments {

    private long paymentID;
    private long requestID;
    private double amount;
    private int paymentMethodId;
    @JsonDeserialize(using = SecondAdapter.class)
    @XmlJavaTypeAdapter(MyAdapter.class)
    private Date paymentDate;
    private String paymentTime;
    private long customerID;

    public Payments() {
    }

    public Payments(long paymentID, long requestID, double amount, int paymentMethodId, Date paymentDate, String paymentTime, long customerID) {
        this.paymentID = paymentID;
        this.requestID = requestID;
        this.amount = amount;
        this.paymentMethodId = paymentMethodId;
        this.paymentDate = paymentDate;
        this.paymentTime = paymentTime;
        this.customerID = customerID;
    }

    public long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(long paymentID) {
        this.paymentID = paymentID;
    }

    public long getRequestID() {
        return requestID;
    }

    public void setRequestID(long requestID) {
        this.requestID = requestID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "paymentID=" + paymentID +
                ", requestID=" + requestID +
                ", amount=" + amount +
                ", paymentMethodId=" + paymentMethodId +
                ", paymentDate=" + paymentDate +
                ", paymentTime='" + paymentTime + '\'' +
                ", customerID=" + customerID +
                '}';
    }
}
