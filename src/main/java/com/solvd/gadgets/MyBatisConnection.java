package com.solvd.gadgets;

import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.CustomerDAO;
import com.solvd.gadgets.dao.impl.myBatis.CustomerDAOImpl;
import org.apache.ibatis.session.SqlSessionFactory;

public class MyBatisConnection {
    public static void main(String[] args) {

      //SqlSessionFactory sqlSessionFactory = CustomerDAOImpl.DaoConfig.getSessionFactory();sqlSessionFactory.openSession(true);
      // CustomerDAO customer = new CustomerDAOImpl(sqlSessionFactory);
      Customer newCustomer = new Customer();
      newCustomer.setFirstName("Ruby");
      newCustomer.setLastName("Miller");
      newCustomer.setPhone(123987123);
      newCustomer.setEmail("rmiller@email.com");
       // customer.create(newCustomer);

    }
}
