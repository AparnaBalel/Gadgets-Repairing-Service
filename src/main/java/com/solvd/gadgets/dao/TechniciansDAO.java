package com.solvd.gadgets.dao;


import com.solvd.gadgets.bin.Technicians;

public interface TechniciansDAO {
    void create(Technicians technicians);

    void deleteByID(int technicianID);
}
