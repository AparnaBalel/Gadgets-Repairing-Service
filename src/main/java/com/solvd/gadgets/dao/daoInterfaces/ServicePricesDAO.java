package com.solvd.gadgets.dao.daoInterfaces;


import com.solvd.gadgets.bin.ServicePrices;

public interface ServicePricesDAO {
    void create(ServicePrices servicePrices);

    void deleteByID(int servicePriceID);
}
