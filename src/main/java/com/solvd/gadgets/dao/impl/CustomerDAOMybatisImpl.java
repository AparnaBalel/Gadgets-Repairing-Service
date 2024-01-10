package com.solvd.gadgets.dao.impl;

import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.CustomerDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class CustomerDAOMybatisImpl implements CustomerDao {
     private final SqlSessionFactory sqlSessionFactory;

    public CustomerDAOMybatisImpl(SqlSessionFactory sqlSessionFactory1) {

        this.sqlSessionFactory = sqlSessionFactory1;
    }

    @Override
    public Optional<Customer> getById(long customerId) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            CustomerDao customerDao =  sqlSession.getMapper(CustomerDao.class);
           return customerDao.getById(customerId);
        }
    }

    @Override
    public Optional<Customer> getByName(String lastName) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            CustomerDao customerDao =  sqlSession.getMapper(CustomerDao.class);
            return customerDao.getByName(lastName);
        }
    }

    @Override
    public void insert(Customer customer) {
        try (SqlSession sqlSession = DaoConfig.getSessionFactory().openSession(true)){
            CustomerDao customerDao =  sqlSession.getMapper(CustomerDao.class);
            customerDao.insert(customer);
            sqlSession.commit();
        }
    }
    @Override
    public void update(Customer customerId) {

    }

    @Override
    public void deleteById(Long customerId) {

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

    public static class DaoConfig {
        private static final SqlSessionFactory sessionFactory;

        public static SqlSessionFactory getSessionFactory() {
            return sessionFactory;
        }

        static{
                try {
                    // Load MyBatis configuration from myBatis-config.xml
                    InputStream is = Resources.getResourceAsStream("myBatis-config.xml");
                    if (is == null) {
                        throw new RuntimeException("myBatis-config.xml not found in the classpath.");
                    }
                    sessionFactory = new SqlSessionFactoryBuilder().build(is);
                } catch (IOException e) {
                    throw new RuntimeException("Error initializing MyBatis SqlSessionFactory.", e);
                }
            }


       }
}
