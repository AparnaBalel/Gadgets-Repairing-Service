package com.solvd.gadgets.bin;
public class ServiceTypes {
    private long serviceTypeID;
    private String typeName;
    public ServiceTypes() {
    }
    public ServiceTypes(long serviceTypeID, String typeName) {
        this.serviceTypeID = serviceTypeID;
        this.typeName = typeName;
    }
    public long getServiceTypeID() {
        return serviceTypeID;
    }
    public void setServiceTypeID(long serviceTypeID) {
        this.serviceTypeID = serviceTypeID;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    @Override
    public String toString() {
        return "ServiceTypes{" +
                "serviceTypeID=" + serviceTypeID +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
