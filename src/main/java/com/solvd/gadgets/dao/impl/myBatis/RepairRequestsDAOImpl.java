package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.RepairRequests;
import com.solvd.gadgets.dao.RepairRequestsDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepairRequestsDAOImpl implements RepairRequestsDAO {
    private static final Logger LOGGER = LogManager.getLogger(RepairRequestsDAOImpl.class);

    @Override
    public void create(RepairRequests repairRequests) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            RepairRequestsDAO repairRequestsDAO =  sqlSession.getMapper(RepairRequestsDAO.class);
            repairRequestsDAO.create(repairRequests);
            sqlSession.commit();

        } catch (PersistenceException e) {
            LOGGER.error("something went wrong can't create new repairRequest");
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(int requestID) {

    }
}
