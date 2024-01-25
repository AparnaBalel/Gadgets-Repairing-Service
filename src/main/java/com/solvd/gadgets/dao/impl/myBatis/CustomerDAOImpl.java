package com.solvd.gadgets.dao.impl.myBatis;

import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.CustomerDAO;
import com.solvd.gadgets.util.myBatisConfig;
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
        try (SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true)){
            CustomerDAO customerDao =  sqlSession.getMapper(CustomerDAO.class);
           return customerDao.getById(customerId);
        }
    }

    @Override
    public void create(Customer customer) {
        try (SqlSession sqlSession = myBatisConfig.getSessionFactory().openSession(true)){
            CustomerDAO customerDao =  sqlSession.getMapper(CustomerDAO.class);
            customerDao.create(customer);
            sqlSession.commit();

        }
    }
    @Override
    public void update(Customer customerId) {

    }
    @Override
    public void deleteById(long customerId) {

    }
    @Override
    public List<Customer> getAllCustomer() {
        return null;
    }

    @Override
    public boolean isEmailAlreadyExists(String Email) {
        return false;
    }

    @Override
    public Customer getCustomerByEmail(String Email) {
        return null;
    }

}
