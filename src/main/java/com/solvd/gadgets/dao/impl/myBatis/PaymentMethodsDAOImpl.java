package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.PaymentMethods;
import com.solvd.gadgets.dao.PaymentMethodsDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentMethodsDAOImpl implements PaymentMethodsDAO {
    private static final Logger LOGGER = LogManager.getLogger(PaymentMethodsDAOImpl.class);
    @Override
    public void create(PaymentMethods paymentMethods) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            PaymentMethodsDAO paymentMethodsDAO =  sqlSession.getMapper(PaymentMethodsDAO.class);
            paymentMethodsDAO.create(paymentMethods);
            sqlSession.commit();

        } catch (PersistenceException e) {
            LOGGER.error("something went wrong can't create new paymentMethods");
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(int paymentMethodID) {

    }
}
