package com.solvd.gadgets_Repairing_Service.bin;

import java.util.Date;

public class RepairAssignments {

    private long assignmentID;
    private long requestId;
    private long technicianID;
    private Date assignmentDate;

    public RepairAssignments() {
    }

    public RepairAssignments(long assignmentID, long requestId, long technicianID, Date assignmentDate) {
        this.assignmentID = assignmentID;
        this.requestId = requestId;
        this.technicianID = technicianID;
        this.assignmentDate = assignmentDate;
    }

    public long getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(long assignmentID) {
        this.assignmentID = assignmentID;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public long getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(long technicianID) {
        this.technicianID = technicianID;
    }

    public Date getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    @Override
    public String toString() {
        return "RepairAssignments{" +
                "assignmentID=" + assignmentID +
                ", requestId=" + requestId +
                ", technicianID=" + technicianID +
                ", assignmentDate=" + assignmentDate +
                '}';
    }
}
