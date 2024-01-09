package com.solvd.gadgets_Repairing_Service.dao.impl;

import com.solvd.gadgets_Repairing_Service.bin.Customer;
import com.solvd.gadgets_Repairing_Service.dao.CustomerDao;
import com.solvd.gadgets_Repairing_Service.dao.DaoConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
}
