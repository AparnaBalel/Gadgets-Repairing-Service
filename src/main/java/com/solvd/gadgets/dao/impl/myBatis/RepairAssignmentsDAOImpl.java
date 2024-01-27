package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.RepairAssignments;
import com.solvd.gadgets.dao.RepairAssignmentsDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepairAssignmentsDAOImpl implements RepairAssignmentsDAO {
    private static final Logger LOGGER = LogManager.getLogger(RepairAssignmentsDAOImpl.class);
    @Override
    public void create(RepairAssignments repairAssignments) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            RepairAssignmentsDAO repairAssignmentsDAO =  sqlSession.getMapper(RepairAssignmentsDAO.class);
            repairAssignmentsDAO.create(repairAssignments);
            sqlSession.commit();

        } catch (PersistenceException e) {
            LOGGER.error("something went wrong can't create new repairAssignment");
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(int assignmentID) {

    }
}
