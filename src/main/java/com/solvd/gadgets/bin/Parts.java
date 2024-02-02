package com.solvd.gadgets.bin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Parts {
    @JsonProperty("partID")

    private long partID;
    @JsonProperty("partName")

    private String partName;
    @JsonProperty("partCost")

    private double partCost;

    @JsonProperty("Parts")
    private List<Parts> parts;

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    public Parts() {
    }
    public Parts(long partID, String partName, double partCost) {
        this.partID = partID;
        this.partName = partName;
        this.partCost = partCost;
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
