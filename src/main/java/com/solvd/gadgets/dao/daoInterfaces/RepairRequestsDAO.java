package com.solvd.gadgets.dao.daoInterfaces;


import com.solvd.gadgets.bin.RepairRequests;

public interface RepairRequestsDAO {
    void create(RepairRequests repairRequests);

    void deleteByID(int requestID);
}
