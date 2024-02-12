package com.solvd.gadgets.dao.impl.jdbc;

import com.solvd.gadgets.bin.RepairParts;
import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.dao.daoInterfaces.RepairPartsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class RepairPartsDAOImpl implements RepairPartsDAO {
    private static final Logger LOGGER= LogManager.getLogger(TechniciansDAOImpl.class);

    @Override
    public void create(RepairParts repairParts) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Repair_Parts (Request_ID, Part_ID, Quantity)  VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, repairParts.getRequestID());
            preparedStatement.setLong(2, repairParts.getPartID());
            preparedStatement.setInt(3, repairParts.getQuantity());
            
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                repairParts.setRepairPartID(resultSet.getLong(100));
            }
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't create new repairParts");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(int repairPartID) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        String query = "DELETE FROM Repair_Parts  WHERE repairPartID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, repairPartID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't delete repair parts");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }
}
