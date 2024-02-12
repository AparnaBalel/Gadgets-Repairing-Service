package com.solvd.gadgets.dao.impl.jdbc;

import com.solvd.gadgets.bin.RepairAssignments;
import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.dao.daoInterfaces.RepairAssignmentsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class RepairAssignmentsDAOImpl implements RepairAssignmentsDAO {
    private static final Logger LOGGER= LogManager.getLogger(TechniciansDAOImpl.class);


    @Override
    public void create(RepairAssignments repairAssignments) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Repair_Assignments (Request_ID, Technician_ID, AssignmentDate)  VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, repairAssignments.getRequestId());
            preparedStatement.setLong(2, repairAssignments.getTechnicianID());
            preparedStatement.setDate(3, (Date) repairAssignments.getAssignmentDate());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                repairAssignments.getAssignmentID(resultSet.getLong(100));
            }
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't create new repair Assignments");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(int assignmentID) {
        Connection connection = ConnectionPool.getConnection();
        String query = "DELETE FROM Repair_Assignments WHERE assignmentID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, assignmentID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't delete assignment ");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }
}
