package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.ServiceTypes;
import com.solvd.gadgets.dao.daoInterfaces.CustomerDAO;
import com.solvd.gadgets.dao.daoInterfaces.ServiceTypesDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServiceTypesDAOImpl implements ServiceTypesDAO {
    private static final Logger LOGGER = LogManager.getLogger(ServiceTypesDAOImpl.class);

    @Override
    public void create(ServiceTypes serviceTypes) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            ServiceTypesDAO serviceTypesDAO =  sqlSession.getMapper(ServiceTypesDAO.class);
            serviceTypesDAO.create(serviceTypes);
            sqlSession.commit();

        } catch (PersistenceException e) {
            LOGGER.error("something went wrong can't create new customer");
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(int serviceTypeID) {
        SqlSession sqlSession = null;

        try {
            sqlSession = myBatisConfig.getSessionFactory().openSession(true);
            ServiceTypesDAO serviceTypesDAO =  sqlSession.getMapper(ServiceTypesDAO.class);
            serviceTypesDAO.deleteByID(serviceTypeID);
            sqlSession.commit();
        }
        catch (PersistenceException e) {
            LOGGER.error("something went wrong can't delete service type by id");
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
