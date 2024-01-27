package com.solvd.gadgets.dao;

import com.solvd.gadgets.bin.Reviews;

public interface ReviewsDAO {
    void create(Reviews reviews);

    void deleteByID(int reviewID);
}
