package com.solvd.gadgets_Repairing_Service.dao;

import com.solvd.gadgets_Repairing_Service.bin.Gadgets;

import java.util.List;

public interface GadgetsDao {
    Gadgets getGadgetById(int gadgetId);
    List<Gadgets> getAllGadgets();
    void addGadget(Gadgets gadget);
    void updateGadget(Gadgets gadget);
    void deleteGadget(int gadgetId);
}
