package com.solvd.gadgets.bin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Parts {

    private long partID;
    private String partName;
    private double partCost;

    private List<Parts> parts;

    public Parts() {
    }

    public Parts(long partID, String partName, double partCost) {
        this.partID = partID;
        this.partName = partName;
        this.partCost = partCost;
    }

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    public long getPartID() {
        return partID;
    }

    public void setPartID(long partID) {
        this.partID = partID;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public double getPartCost() {
        return partCost;
    }

    public void setPartCost(double partCost) {
        this.partCost = partCost;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "partID=" + partID +
                ", partName='" + partName + '\'' +
                ", partCost=" + partCost +
                '}';
    }
}
