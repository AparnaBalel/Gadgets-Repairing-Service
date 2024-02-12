package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.Gadgets;
import com.solvd.gadgets.dao.daoInterfaces.GadgetsDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Optional;

public class GadgetsDAOImpl implements GadgetsDAO {
    private static final Logger LOGGER = LogManager.getLogger(GadgetsDAOImpl.class);
    @Override
    public Optional<Gadgets> getGadgetById(int gadgetId) {

        try (SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true)) {
            GadgetsDAO gadgetsDAO =  sqlSession.getMapper(GadgetsDAO.class);
            return gadgetsDAO.getGadgetById(gadgetId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Gadgets> getAllGadgets() {

        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(false);
        List<Gadgets> gadgetsList= null;
        try {
            gadgetsList = sqlSession.selectList("GadgetsDAO.getAllGadgets");
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving all gadgets: " + e.getMessage());
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return gadgetsList;
    }

    @Override
    public void create(Gadgets gadget) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            GadgetsDAO gadgetsDAO =  sqlSession.getMapper(GadgetsDAO.class);
            gadgetsDAO.create(gadget);
            sqlSession.commit();
        } catch (PersistenceException e) {
            LOGGER.error("something went wrong can't create new gadget");
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }

    }

    @Override
    public void delete(int gadgetId) {
        SqlSession sqlSession = null;
        try {
            sqlSession = myBatisConfig.getSessionFactory().openSession(true);
            GadgetsDAO gadgetsDAO =  sqlSession.getMapper(GadgetsDAO.class);
            gadgetsDAO.delete(gadgetId);
            sqlSession.commit();
        }
        catch (PersistenceException e) {
            LOGGER.error("something went wrong can't delete gadget by id");
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

    }

}
