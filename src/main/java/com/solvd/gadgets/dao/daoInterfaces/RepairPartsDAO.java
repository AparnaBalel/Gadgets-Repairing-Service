package com.solvd.gadgets.dao.daoInterfaces;


import com.solvd.gadgets.bin.RepairParts;

public interface RepairPartsDAO {
    void create(RepairParts repairParts);

    void deleteByID(int repairPartID);
}
