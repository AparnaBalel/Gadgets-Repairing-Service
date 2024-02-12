package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.Parts;
import com.solvd.gadgets.dao.daoInterfaces.PartsDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PartsDAOImpl implements PartsDAO {
    private static final Logger LOGGER = LogManager.getLogger(PartsDAOImpl.class);

    @Override
    public void create(Parts parts) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            PartsDAO partsDAO =  sqlSession.getMapper(PartsDAO.class);
            partsDAO.create(parts);
            sqlSession.commit();

        } catch (PersistenceException e) {
            LOGGER.error("something went wrong can't create new parts");
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }

    }

    @Override
    public void deleteByID(int partID) {
        SqlSession sqlSession = null;

        try {
            sqlSession = myBatisConfig.getSessionFactory().openSession(true);
            PartsDAO partsDAO =  sqlSession.getMapper(PartsDAO.class);
            partsDAO.deleteByID(partID);
            sqlSession.commit();
        }
        catch (PersistenceException e) {
            LOGGER.error("something went wrong can't delete part by id");
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }
}
