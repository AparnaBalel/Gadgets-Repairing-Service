package com.solvd.gadgets.dao.impl.jdbc;

import com.solvd.gadgets.bin.ServicePrices;
import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.dao.daoInterfaces.ServicePricesDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class ServicePricesDAOImpl implements ServicePricesDAO {
    private static final Logger LOGGER= LogManager.getLogger(TechniciansDAOImpl.class);

    @Override
    public void create(ServicePrices servicePrices) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
           ("INSERT INTO Service_Prices (Service_Type_ID, Price)  VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, servicePrices.getServicePriceID());
            preparedStatement.setDouble(2, servicePrices.getServicePriceID());

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                servicePrices.setServicePriceID(resultSet.getLong(100));
            }
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't create new technician");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(int servicePriceID) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        String query = "DELETE FROM Service_Prices WHERE servicePriceID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, servicePriceID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't delete service price");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }
}
