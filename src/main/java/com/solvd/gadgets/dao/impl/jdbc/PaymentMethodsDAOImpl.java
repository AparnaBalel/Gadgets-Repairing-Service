package com.solvd.gadgets.dao.impl.jdbc;

import com.solvd.gadgets.bin.PaymentMethods;
import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.dao.daoInterfaces.PaymentMethodsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class PaymentMethodsDAOImpl implements PaymentMethodsDAO {
    private static final Logger LOGGER= LogManager.getLogger(TechniciansDAOImpl.class);

    @Override
    public void create(PaymentMethods paymentMethods) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Payment_Methods (Method_Name)  VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paymentMethods.getMethodName());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                paymentMethods.setPaymentMethodID(resultSet.getLong(100));
            }
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't create new payment method");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(int paymentMethodID) {
        Connection connection = ConnectionPool.getConnection();
        String query = "DELETE FROM Payment_Methods WHERE paymentMethodID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, paymentMethodID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't delete payment method");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }
}
