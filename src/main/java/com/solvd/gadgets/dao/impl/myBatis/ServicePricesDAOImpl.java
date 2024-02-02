package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.ServicePrices;
import com.solvd.gadgets.dao.daoInterfaces.ServicePricesDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServicePricesDAOImpl implements ServicePricesDAO {
    private static final Logger LOGGER = LogManager.getLogger(ServicePricesDAOImpl.class);
    @Override
    public void create(ServicePrices servicePrices) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            ServicePricesDAO servicePricesDAO =  sqlSession.getMapper(ServicePricesDAO.class);
            servicePricesDAO.create(servicePrices);
            sqlSession.commit();

        } catch (PersistenceException e) {
            LOGGER.error("something went wrong can't create new servicePrice");
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(int servicePriceID) {

    }
}
