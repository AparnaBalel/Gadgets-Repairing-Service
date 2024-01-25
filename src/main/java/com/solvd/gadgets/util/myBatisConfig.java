package com.solvd.gadgets.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class myBatisConfig {
    private static final SqlSessionFactory sessionFactory;

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



    public static SqlSessionFactory getSessionFactory() {

        return sessionFactory;
    }
}
