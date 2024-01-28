package com.solvd.gadgets.dao.impl.myBatis;


import com.solvd.gadgets.bin.Gadgets;
import com.solvd.gadgets.dao.GadgetsDAO;
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
        return Optional.empty();
    }

    @Override
    public List<Gadgets> getAllGadgets() {
        return null;
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
    public void update(int gadgetId) {

    }

    @Override
    public void delete(int gadgetId) {

    }

    @Override
    public void update(Gadgets gadgetId) {

    }

    @Override
    public void delete(Gadgets gadgetId) {

    }

}
