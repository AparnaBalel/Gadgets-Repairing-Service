package com.solvd.gadgets.dao;


import com.solvd.gadgets.bin.RepairAssignments;

public interface RepairAssignmentsDAO {
    void create(RepairAssignments repairAssignments);

    void deleteByID(RepairAssignments assignmentID);
}
