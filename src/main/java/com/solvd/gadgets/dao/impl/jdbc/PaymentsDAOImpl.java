package com.solvd.gadgets.dao.impl.jdbc;

import com.solvd.gadgets.bin.Payments;
import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.dao.daoInterfaces.PaymentsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class PaymentsDAOImpl implements PaymentsDAO {
    private static final Logger LOGGER= LogManager.getLogger(TechniciansDAOImpl.class);

    @Override
    public void create(Payments payments) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO payments ( Request_ID, Amount, Payment_Method_ID, Payment_Date, Payment_Time)  VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, payments.getRequestID().getRequestID());
            preparedStatement.setDouble(2, payments.getAmount());
            preparedStatement.setLong(3, payments.getPaymentID());
            preparedStatement.setDate(4, payments.getPaymentDate());
            preparedStatement.setDate(5, payments.getPaymentTime());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                payments.setPaymentID(resultSet.getLong(100));
            }
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't create new payments");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(int paymentID) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        String query = "DELETE FROM Payments WHERE paymentID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, paymentID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't create new technician");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }
}
