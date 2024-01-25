package com.solvd.gadgets.dao;


import com.solvd.gadgets.bin.ServicePrices;

public interface ServicePricesDAO {
    void create(ServicePrices servicePrices);

    void deleteByID(ServicePrices servicePriceID);
}
