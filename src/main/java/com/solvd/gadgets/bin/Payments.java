package com.solvd.gadgets.bin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.gadgets.util.MyAdapter;
import com.solvd.gadgets.util.SecondAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.sql.Date;
import java.sql.Timestamp;

public class Payments {
    private long paymentID;
    private RepairRequests requestID;
    private double amount;
    private PaymentMethods paymentMethodId;
    @JsonDeserialize(using = SecondAdapter.class)
    @XmlJavaTypeAdapter(MyAdapter.class)
    private Date paymentDate;
    private Date paymentTime;
    public Payments() {
    }

    public Payments(long paymentID, RepairRequests requestID, double amount, PaymentMethods paymentMethodId, Date paymentDate, Date paymentTime) {
        this.paymentID = paymentID;
        this.requestID = requestID;
        this.amount = amount;
        this.paymentMethodId = paymentMethodId;
        this.paymentDate = paymentDate;
        this.paymentTime = paymentTime;
    }

    public long getPaymentID() {
        return paymentID;
    }
    public void setPaymentID(long paymentID) {
        this.paymentID = paymentID;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public RepairRequests getRequestID() {
        return requestID;
    }

    public void setRequestID(RepairRequests requestID) {
        this.requestID = requestID;
    }

    public PaymentMethods getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(PaymentMethods paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "paymentID=" + paymentID +
                ", requestID=" + requestID +
                ", amount=" + amount +
                ", paymentMethodId=" + paymentMethodId +
                ", paymentDate=" + paymentDate +
                ", paymentTime=" + paymentTime +
                '}';
    }
}
