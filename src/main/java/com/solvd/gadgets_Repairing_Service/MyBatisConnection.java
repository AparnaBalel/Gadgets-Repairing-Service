package com.solvd.gadgets_Repairing_Service;

import com.solvd.gadgets_Repairing_Service.bin.Customer;
import com.solvd.gadgets_Repairing_Service.dao.CustomerDao;
import com.solvd.gadgets_Repairing_Service.dao.DaoConfig;
import com.solvd.gadgets_Repairing_Service.dao.impl.CustomerDAOMybatisImpl;
import org.apache.ibatis.session.SqlSessionFactory;

public class MyBatisConnection {
    public static void main(String[] args) {

       SqlSessionFactory sqlSessionFactory = DaoConfig.getSessionFactory();
        sqlSessionFactory.openSession(true);
       CustomerDao customer = new CustomerDAOMybatisImpl(sqlSessionFactory);
      Customer newCustomer = new Customer();
      newCustomer.setFirstName("Ruby");
      newCustomer.setLastName("Miller");
      newCustomer.setPhone(123987123);
      newCustomer.setEmail("rmiller@email.com");
        customer.insert(newCustomer);

    }
}
