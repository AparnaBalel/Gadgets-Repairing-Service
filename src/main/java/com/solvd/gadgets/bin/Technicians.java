package com.solvd.gadgets.bin;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "company")
public class Technicians {
   // @XmlAttribute (name = "id")
    private long technicianID;
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNumber;
    private List<Technicians> technicianList;
    @JsonProperty("technicians")


    @XmlElementWrapper(name = "technicians")
    @XmlElement(name = "technician")
    public List<Technicians> getTechnicianList() {
        return technicianList;
    }

    public void setTechnicianList(List<Technicians> technicianList) {
        this.technicianList = technicianList;
    }

    public Technicians() {
    }
    public Technicians(long technicianID, String firstName, String lastName, String email, long phoneNumber) {
        this.technicianID = technicianID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public long getTechnicianID() {
        return technicianID;
    }

    public void setTechnicianID(long technicianID) {
        this.technicianID = technicianID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "Technicians{" +
                "technicianID=" + technicianID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }


}