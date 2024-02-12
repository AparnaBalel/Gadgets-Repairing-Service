package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.Technicians;
import com.solvd.gadgets.dao.daoInterfaces.CustomerDAO;
import com.solvd.gadgets.dao.daoInterfaces.TechniciansDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TechniciansDAOImpl implements TechniciansDAO {

    private static final Logger LOGGER = LogManager.getLogger(TechniciansDAOImpl.class);

    @Override
    public void create(Technicians technicians) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            TechniciansDAO techniciansDAO =  sqlSession.getMapper(TechniciansDAO.class);
            techniciansDAO.create(technicians);
            sqlSession.commit();

        } catch (PersistenceException e) {
            LOGGER.error("something went wrong can't create new technician");
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public void deleteByID(int technicianID) {
        SqlSession sqlSession = null;

        try {
            sqlSession = myBatisConfig.getSessionFactory().openSession(true);
            TechniciansDAO techniciansDAO =  sqlSession.getMapper(TechniciansDAO.class);
            techniciansDAO.deleteByID(technicianID);
            sqlSession.commit();
        }
        catch (PersistenceException e) {
            LOGGER.error("something went wrong can't delete customer by id");
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
