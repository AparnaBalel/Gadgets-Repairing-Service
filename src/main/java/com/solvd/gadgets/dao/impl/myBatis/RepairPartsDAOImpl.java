package com.solvd.gadgets.dao.impl.myBatis;


import com.solvd.gadgets.bin.RepairParts;
import com.solvd.gadgets.dao.RepairPartsDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepairPartsDAOImpl implements RepairPartsDAO {
    private static final Logger LOGGER = LogManager.getLogger(RepairPartsDAOImpl.class);

    @Override
    public void create(RepairParts repairParts) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            RepairPartsDAO repairPartsDAO =  sqlSession.getMapper(RepairPartsDAO.class);
            repairPartsDAO.create(repairParts);
            sqlSession.commit();

        } catch (PersistenceException e) {
            LOGGER.error("something went wrong can't create new repairPart");
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(int repairPartID) {

    }
}
