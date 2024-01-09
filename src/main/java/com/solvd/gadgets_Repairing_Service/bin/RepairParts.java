package com.solvd.gadgets_Repairing_Service.bin;

public class RepairParts {

    private long repairPartID;
    private long requestID;
    private long partID;
    private int quantity;

    public RepairParts() {
    }

    public RepairParts(long repairPartID, long requestID, long partID, int quantity) {
        this.repairPartID = repairPartID;
        this.requestID = requestID;
        this.partID = partID;
        this.quantity = quantity;
    }

    public long getRepairPartID() {
        return repairPartID;
    }

    public void setRepairPartID(long repairPartID) {
        this.repairPartID = repairPartID;
    }

    public long getRequestID() {
        return requestID;
    }

    public void setRequestID(long requestID) {
        this.requestID = requestID;
    }

    public long getPartID() {
        return partID;
    }

    public void setPartID(long partID) {
        this.partID = partID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RepairParts{" +
                "repairPartID=" + repairPartID +
                ", requestID=" + requestID +
                ", partID=" + partID +
                ", quantity=" + quantity +
                '}';
    }
}
