package com.solvd.gadgets.dao.daoInterfaces;


import com.solvd.gadgets.bin.RepairAssignments;

public interface RepairAssignmentsDAO {
    void create(RepairAssignments repairAssignments);

    void deleteByID(int assignmentID);
}
