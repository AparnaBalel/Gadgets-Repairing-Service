package com.solvd.gadgets_Repairing_Service.bin;

import java.util.Date;

public class RepairRequests {

    private long requestID;
    private long customerID;
    private long gadgetID;
    private String issueDescription;
    private long statusID;
    private Date requestDate;

    public RepairRequests() {
    }

    public RepairRequests(long requestID, long customerID, long gadgetID, String issueDescription, long statusID, Date requestDate) {
        this.requestID = requestID;
        this.customerID = customerID;
        this.gadgetID = gadgetID;
        this.issueDescription = issueDescription;
        this.statusID = statusID;
        this.requestDate = requestDate;
    }

    public long getRequestID() {
        return requestID;
    }

    public void setRequestID(long requestID) {
        this.requestID = requestID;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public long getGadgetID() {
        return gadgetID;
    }

    public void setGadgetID(long gadgetID) {
        this.gadgetID = gadgetID;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public long getStatusID() {
        return statusID;
    }

    public void setStatusID(long statusID) {
        this.statusID = statusID;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "RepairRequests{" +
                "requestID=" + requestID +
                ", customerID=" + customerID +
                ", gadgetID=" + gadgetID +
                ", issueDescription='" + issueDescription + '\'' +
                ", statusID=" + statusID +
                ", requestDate=" + requestDate +
                '}';
    }
}
