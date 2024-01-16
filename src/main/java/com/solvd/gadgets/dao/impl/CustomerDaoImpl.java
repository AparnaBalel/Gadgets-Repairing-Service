package com.solvd.gadgets.dao.impl;

import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.bin.Customer;
import com.solvd.gadgets.dao.CustomerDao;
import com.solvd.gadgets.util.DomParser;
import org.apache.logging.log4j.LogManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(CustomerDaoImpl.class);
  Connection connection = ConnectionPool.getConnection();
    Customer customer = new Customer();
    PreparedStatement preparedStatement;
    ResultSet resultSet;


    @Override
    public Optional<Customer> getById(long customerId)  {
        Connection connection = ConnectionPool.getConnection();
        Customer customer = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM Customers WHERE CustomerID = ?";
        try (PreparedStatement  preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setLong(1,customerId);
            resultSet = preparedStatement.executeQuery();
            customer = new Customer();
            if (resultSet.next()){
                customer.setCustomerID(resultSet.getLong("CustomerID"));
                customer.setFirstName(resultSet.getString("FirstName"));
                customer.setLastName(resultSet.getString("LastName"));
                customer.setPhone(resultSet.getLong("Phone"));
                customer.setEmail(resultSet.getString("Email"));
            }
        } catch (SQLException e) {
            LOGGER.error("something went wrong");
        }finally {
            if (resultSet!= null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    resultSet = null;
                }
            }
            ConnectionPool.releaseConnection(connection);
        }
        return Optional.of(customer);
    }

    @Override
    public Optional<Customer> getByName(String lastName) {

        return Optional.empty();
    }

    private static final List<Customer> customers = new ArrayList<>();

    @Override
    public void insert(Customer customer) {
        try {
            preparedStatement =connection.prepareStatement("INSERT INTO Customers(FirstName, LastName, Phone, Email) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setLong(3, customer.getPhone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                customer.setCustomerID(resultSet.getLong(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionPool.releaseConnection(connection);
        }
    }
    @Override
    public boolean isEmailAlreadyExists(String Email) {
        return customers.stream().anyMatch(customer -> customer.getEmail().equals(Email));
    }

    @Override
    public Customer getCustomerByEmail(String customerEmail) {
        return customers.stream()
                .filter(customer -> customer.getEmail().equals(customerEmail))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update( Customer customerId) {
        String query = "UPDATE Customers SET FirstName = ?  WHERE CustomerID = ? ";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,customer.getFirstName());
            preparedStatement.setLong(2, customer.getCustomerID());
           preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long customerId) {
        String query = "DELETE FROM Customers WHERE CustomerID = ?";
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, customerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM Customers ";
        try {
            preparedStatement =connection.prepareStatement(query);
           resultSet = preparedStatement.executeQuery();

            while  (resultSet.next()){
                customer.setCustomerID(resultSet.getLong("customer id"));
                customer.setFirstName(resultSet.getString("firstName"));
                customer.setLastName(resultSet.getString("lastName"));
                customer.setPhone(resultSet.getLong("phoneNumber"));
                customer.setEmail(resultSet.getString("emailID"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
}
