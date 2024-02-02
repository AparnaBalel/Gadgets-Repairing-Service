package com.solvd.gadgets.dao.daoInterfaces;

import com.solvd.gadgets.bin.Reviews;

public interface ReviewsDAO {
    void create(Reviews reviews);

    void deleteByID(int reviewID);
}
