package com.solvd.gadgets.dao.daoInterfaces;


import com.solvd.gadgets.bin.Gadgets;

import java.util.List;
import java.util.Optional;

public interface GadgetsDAO {
    Optional<Gadgets> getGadgetById(int gadgetId) ;
    List<Gadgets> getAllGadgets();
    void create(Gadgets gadget);
    void update(int gadgetId);
    void delete(int gadgetId);

    void update(Gadgets gadgetId);

    void delete(Gadgets gadgetId);
}
