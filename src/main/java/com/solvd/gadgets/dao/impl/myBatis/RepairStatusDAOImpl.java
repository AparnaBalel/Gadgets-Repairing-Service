package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.RepairServices;
import com.solvd.gadgets.dao.RepairServicesDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepairStatusDAOImpl implements RepairServicesDAO {
    private static final Logger LOGGER = LogManager.getLogger(RepairStatusDAOImpl.class);
    @Override
    public void create(RepairServices repairServices) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            RepairServicesDAO repairServicesDAO =  sqlSession.getMapper(RepairServicesDAO.class);
            repairServicesDAO.create(repairServices);
            sqlSession.commit();

        } catch (PersistenceException e) {
            LOGGER.error("something went wrong can't create new repairService");
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(int repairServiceID) {

    }
}
