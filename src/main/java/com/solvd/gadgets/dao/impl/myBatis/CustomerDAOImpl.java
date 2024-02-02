package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.daoInterfaces.CustomerDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {

    private static final Logger LOGGER = LogManager.getLogger(CustomerDAO.class);

    public Optional<Customer> getById(int customerId) {
        try (SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true)) {
            CustomerDAO customerDao = sqlSession.getMapper(CustomerDAO.class);
            return customerDao.getById(customerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void create(Customer customer) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            CustomerDAO customerDao = sqlSession.getMapper(CustomerDAO.class);
            customerDao.create(customer);
            sqlSession.commit();

        } catch (PersistenceException e) {
            LOGGER.error("something went wrong can't create new customer mybatis");
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void update(int customerId) {
        try (SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true)) {
            CustomerDAO customerDao = sqlSession.getMapper(CustomerDAO.class);
            customerDao.update(customerId);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteById(int customerId) {
        try (SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true)) {
            CustomerDAO customerDao = sqlSession.getMapper(CustomerDAO.class);
            customerDao.deleteById(customerId);
            sqlSession.commit();
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(false);
        List<Customer> customers = null;
        try {
            customers = sqlSession.selectList("CustomerDAO.getAllCustomer");
        } catch (Exception e) {
            LOGGER.error("Error occurred while retrieving all customers: " + e.getMessage());
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
        return customers;
    }
}
