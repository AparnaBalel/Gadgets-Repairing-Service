package com.solvd.gadgets.dao;

import com.solvd.gadgets.bin.Reviews;

public interface ReviewsDAO {
    void create(Reviews reviews);

    void deleteByID(Reviews reviewID);
}
