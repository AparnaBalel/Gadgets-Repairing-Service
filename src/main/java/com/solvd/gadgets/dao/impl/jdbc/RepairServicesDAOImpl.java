package com.solvd.gadgets.dao.impl.jdbc;

import com.solvd.gadgets.bin.RepairServices;
import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.dao.daoInterfaces.RepairServicesDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class RepairServicesDAOImpl implements RepairServicesDAO {

    private static final Logger LOGGER= LogManager.getLogger(TechniciansDAOImpl.class);


    @Override
    public void create(RepairServices repairServices) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Repair_Services (Request_ID, Service_Type_ID, Service_Price_ID)  VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, repairServices.getRequestID());
            preparedStatement.setLong(2, repairServices.getServiceTypeID());
            preparedStatement.setLong(3, repairServices.getServicePriceID());

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                repairServices.setRepairServiceID(resultSet.getLong(100));
            }
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't create new repair Services");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(int repairServiceID) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        String query = "DELETE FROM Repair_Services WHERE repairServiceID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, repairServiceID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't delete repair service");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }
}
