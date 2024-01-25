package com.solvd.gadgets.dao;

import com.solvd.gadgets.bin.Gadgets;

import java.util.List;

public interface GadgetsDAO {
    Gadgets getGadgetById(int gadgetId);
    List<Gadgets> getAllGadgets();
    void create(Gadgets gadget);
    void update(int gadgetId);
    void delete(int gadgetId);
}
