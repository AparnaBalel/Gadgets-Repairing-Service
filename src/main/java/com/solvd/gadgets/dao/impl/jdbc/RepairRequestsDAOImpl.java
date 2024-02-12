package com.solvd.gadgets.dao.impl.jdbc;

import com.solvd.gadgets.bin.RepairRequests;
import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.dao.daoInterfaces.RepairRequestsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class RepairRequestsDAOImpl  implements RepairRequestsDAO {
    private static final Logger LOGGER= LogManager.getLogger(TechniciansDAOImpl.class);

    @Override
    public void create(RepairRequests repairRequests) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Repair_Requests (Customer_ID, Gadget_ID, Issue_Description, Status_ID, RequestDate)  VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, repairRequests.getCustomerID());
            preparedStatement.setLong(2, repairRequests.getGadgetID());
            preparedStatement.setString(3, repairRequests.getIssueDescription());
            preparedStatement.setLong(4, repairRequests.getStatusID());
            preparedStatement.setDate(5, (Date) repairRequests.getRequestDate());

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                repairRequests.setRequestID(resultSet.getLong(100));
            }
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't create new repairRequests");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(int requestID) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        String query = "DELETE FROM Repair_Requests WHERE requestID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, requestID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't delete repair request");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }
}
