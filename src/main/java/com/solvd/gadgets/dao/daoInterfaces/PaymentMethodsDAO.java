package com.solvd.gadgets.dao.daoInterfaces;


import com.solvd.gadgets.bin.PaymentMethods;

public interface PaymentMethodsDAO {
    void create(PaymentMethods paymentMethods);

    void deleteByID(int paymentMethodID );
}
