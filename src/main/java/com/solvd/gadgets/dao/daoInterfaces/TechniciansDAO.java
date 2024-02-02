package com.solvd.gadgets.dao.daoInterfaces;


import com.solvd.gadgets.bin.Technicians;

public interface TechniciansDAO {
    void create(Technicians technicians);

    void deleteByID(int technicianID);
}
