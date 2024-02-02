package com.solvd.gadgets.dao.daoInterfaces;

import com.solvd.gadgets.bin.RepairStatus;

public interface RepairStatusDAO {
    void create(RepairStatus repairStatus);

    void deleteByID(int statusID );
}
