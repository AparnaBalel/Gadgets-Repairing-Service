package com.solvd.gadgets.dao.impl.jdbc;

import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.daoInterfaces.CustomerDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {
    private static final Logger LOGGER = LogManager.getLogger(CustomerDAOImpl.class);

    @Override
    public Optional<Customer> getById(int customerId) {
        Connection connection = ConnectionPool.getConnection();
        Customer customer = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM Customers WHERE CustomerID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, customerId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = new Customer();
                customer.setCustomerID(resultSet.getLong("CustomerID"));
                customer.setFirstName(resultSet.getString("FirstName"));
                customer.setLastName(resultSet.getString("LastName"));
                customer.setPhone(resultSet.getLong("Phone"));
                customer.setEmail(resultSet.getString("Email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionPool.releaseConnection(connection);
        }
        return Optional.ofNullable(customer);
    }

    @Override
    public void create(Customer customer) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customers(FirstName, LastName, Phone, Email) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setLong(3, customer.getPhone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                customer.setCustomerID(resultSet.getLong(100));
            }
        } catch (SQLException e) {
            LOGGER.error("something went wrong in customerDAO class");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void update(int customerId) {
        Connection connection = ConnectionPool.getConnection();
        Customer customer = null;
        String query = "UPDATE Customers SET FirstName = ?  WHERE CustomerID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setLong(2, customer.getCustomerID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("something went wrong can't update customer by id");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(int customerId) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        String query = "DELETE FROM Customers WHERE CustomerID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, customerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        Connection connection = ConnectionPool.getConnection();
        List<Customer> customers = new ArrayList<>();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from Customers")) {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(resultSet.getLong("CustomerID"));
                customer.setFirstName(resultSet.getString("FirstName"));
                customer.setLastName(resultSet.getString("LastName"));
                customer.setPhone(resultSet.getLong("Phone"));
                customer.setEmail(resultSet.getString("Email"));
                customers.add(customer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionPool.releaseConnection(connection);
        }

        return customers;
    }
}