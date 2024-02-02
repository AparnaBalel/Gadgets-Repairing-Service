package com.solvd.gadgets.dao.daoInterfaces;


import com.solvd.gadgets.bin.Payments;

public interface PaymentsDAO {
    void create(Payments payments);

    void delete(int paymentID);
}
