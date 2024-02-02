package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.Reviews;
import com.solvd.gadgets.dao.daoInterfaces.ReviewsDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReviewsDAOImpl implements ReviewsDAO {
    private static final Logger LOGGER = LogManager.getLogger(ReviewsDAOImpl.class);

    @Override
    public void create(Reviews reviews) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            ReviewsDAO reviewsDAO =  sqlSession.getMapper(ReviewsDAO.class);
            reviewsDAO.create(reviews);
            sqlSession.commit();

        } catch (PersistenceException e) {
            LOGGER.error("something went wrong can't create new review");
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(int reviewID) {

    }
}
