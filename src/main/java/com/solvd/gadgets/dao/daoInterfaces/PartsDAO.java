package com.solvd.gadgets.dao.daoInterfaces;

import com.solvd.gadgets.bin.Parts;

public interface PartsDAO {
    void create(Parts parts);

    void deleteByID(int partID);
}
