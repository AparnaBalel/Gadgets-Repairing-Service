package com.solvd.gadgets.dao;


import com.solvd.gadgets.bin.ServiceTypes;

public interface ServiceTypesDAO {
    void create(ServiceTypes serviceTypes);

    void deleteByID(int serviceTypeID);
}
