package com.solvd.gadgets.bin;

public class RepairStatus {

    private long statusID;
    private String statusName;

    public RepairStatus() {
    }

    public RepairStatus(long statusID, String statusName) {
        this.statusID = statusID;
        this.statusName = statusName;
    }

    public long getStatusID() {
        return statusID;
    }

    public void setStatusID(long statusID) {
        this.statusID = statusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "RepairStatus{" +
                "statusID=" + statusID +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}
