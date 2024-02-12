package com.solvd.gadgets.dao.impl.jdbc;

import com.solvd.gadgets.bin.ServiceTypes;
import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.dao.daoInterfaces.ServiceTypesDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class ServiceTypesDAOImpl implements ServiceTypesDAO {
    private static final Logger LOGGER= LogManager.getLogger(TechniciansDAOImpl.class);

    @Override
    public void create(ServiceTypes serviceTypes) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
           ("INSERT INTO Service_Types (Type_Name)  VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, serviceTypes.getTypeName());

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                serviceTypes.setServiceTypeID(resultSet.getLong(100));
            }
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't create new service type");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(int serviceTypeID) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        String query = "DELETE FROM Service_Types WHERE serviceTypeID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, serviceTypeID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't delete service type");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }
}
