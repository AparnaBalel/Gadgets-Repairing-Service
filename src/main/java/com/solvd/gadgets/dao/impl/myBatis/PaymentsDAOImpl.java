package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.Payments;
import com.solvd.gadgets.dao.daoInterfaces.PaymentsDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentsDAOImpl implements PaymentsDAO {
    private static final Logger LOGGER = LogManager.getLogger(PaymentsDAOImpl.class);
    @Override
    public void create(Payments payments) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            PaymentsDAO paymentsDAO =  sqlSession.getMapper(PaymentsDAO.class);
            paymentsDAO.create(payments);
            sqlSession.commit();

        } catch (PersistenceException e) {
            LOGGER.error("something went wrong can't create new payment");
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public void delete(int paymentID) {

    }
}
