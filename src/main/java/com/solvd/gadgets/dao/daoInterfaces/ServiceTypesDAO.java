package com.solvd.gadgets.dao.daoInterfaces;


import com.solvd.gadgets.bin.ServiceTypes;

public interface ServiceTypesDAO {
    void create(ServiceTypes serviceTypes);

    void deleteByID(int serviceTypeID);
}
