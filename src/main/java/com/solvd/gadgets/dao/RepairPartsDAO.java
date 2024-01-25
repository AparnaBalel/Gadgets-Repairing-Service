package com.solvd.gadgets.dao;


import com.solvd.gadgets.bin.RepairParts;

public interface RepairPartsDAO {
    void create(RepairParts repairParts);

    void deleteByID(RepairParts repairPartID);
}
