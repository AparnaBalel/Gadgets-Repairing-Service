package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.CustomerDAO;
import com.solvd.gadgets.util.myBatisConfig;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {

    private static final Logger LOGGER= LogManager.getLogger(CustomerDAO.class);

    @Override
    public Optional<Customer> getById(long customerId) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            CustomerDAO customerDao =  sqlSession.getMapper(CustomerDAO.class);
           return customerDao.getById(customerId);
        } catch (Exception e) {
            LOGGER.error("something went wrong can't get customer by id ");
        }
        return null;
    }

    @Override
    public void create(Customer customer) {
        SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true);
        try {
            CustomerDAO customerDao =  sqlSession.getMapper(CustomerDAO.class);
            customerDao.create(customer);
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
    public void update(Customer customerId) {
        try (SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true)) {
            CustomerDAO customerDao = sqlSession.getMapper(CustomerDAO.class);
            customerDao.update(customerId);
            sqlSession.commit();
        }
    }
    @Override
    public void deleteById(long customerId) {
        try (SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true)) {
            CustomerDAO customerDao = sqlSession.getMapper(CustomerDAO.class);
            customerDao.deleteById(customerId);
            sqlSession.commit();
        }
    }
    @Override
    public List<Customer> getAllCustomer() {
        try (SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true)) {
            CustomerDAO customerDao = sqlSession.getMapper(CustomerDAO.class);
            customerDao.getAllCustomer();
            sqlSession.commit();
            return customerDao.getAllCustomer();
        }
    }

    @Override
    public boolean isEmailAlreadyExists(String Email) {
        try (SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true)) {
            CustomerDAO customerDao = sqlSession.getMapper(CustomerDAO.class);
            customerDao.isEmailAlreadyExists(Email);
            sqlSession.commit();
        }        return false;
    }

    @Override
    public Customer getCustomerByEmail(String Email) {
        try (SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true)) {
            CustomerDAO customerDao = sqlSession.getMapper(CustomerDAO.class);
            customerDao.getCustomerByEmail(Email);
            sqlSession.commit();
        }
        return null;
    }

}
