package com.solvd.gadgets.dao;


import com.solvd.gadgets.bin.RepairServices;

public interface RepairServicesDAO {
    void create(RepairServices repairServices);

    void deleteByID(int repairServiceID);
}
