package com.solvd.gadgets.bin;

public class RepairServices {

   private long repairServiceID;
   private long requestID;
   private long serviceTypeID;
   private long servicePriceID;

    public RepairServices() {
    }

    public RepairServices(long repairServiceID, long requestID, long serviceTypeID, long servicePriceID) {
        this.repairServiceID = repairServiceID;
        this.requestID = requestID;
        this.serviceTypeID = serviceTypeID;
        this.servicePriceID = servicePriceID;
    }

    public long getRepairServiceID() {
        return repairServiceID;
    }

    public void setRepairServiceID(long repairServiceID) {
        this.repairServiceID = repairServiceID;
    }

    public long getRequestID() {
        return requestID;
    }

    public void setRequestID(long requestID) {
        this.requestID = requestID;
    }

    public long getServiceTypeID() {
        return serviceTypeID;
    }

    public void setServiceTypeID(long serviceTypeID) {
        this.serviceTypeID = serviceTypeID;
    }

    public long getServicePriceID() {
        return servicePriceID;
    }

    public void setServicePriceID(long servicePriceID) {
        this.servicePriceID = servicePriceID;
    }

    @Override
    public String toString() {
        return "RepairServices{" +
                "repairServiceID=" + repairServiceID +
                ", requestID=" + requestID +
                ", serviceTypeID=" + serviceTypeID +
                ", servicePriceID=" + servicePriceID +
                '}';
    }
}
