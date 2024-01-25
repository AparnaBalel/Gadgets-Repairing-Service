package com.solvd.gadgets.dao;


import com.solvd.gadgets.bin.PaymentMethods;

public interface PaymentMethodsDAO {
    void create(PaymentMethods paymentMethods);

    void deleteByID(PaymentMethods paymentMethodID );
}
