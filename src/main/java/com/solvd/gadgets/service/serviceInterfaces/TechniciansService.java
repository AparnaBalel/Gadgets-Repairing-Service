package com.solvd.gadgets.service.serviceInterfaces;

public interface TechniciansService {

    void insertTechnician(String firstName, String lastName, String Email, long Phone);

    void deleteByID(int technicianID);
    void parsingTechnician();

}
