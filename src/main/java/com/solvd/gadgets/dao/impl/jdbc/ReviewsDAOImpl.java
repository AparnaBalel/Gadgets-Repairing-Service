package com.solvd.gadgets.dao.impl.jdbc;

import com.solvd.gadgets.bin.Reviews;
import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.dao.daoInterfaces.ReviewsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class ReviewsDAOImpl implements ReviewsDAO {

    private static final Logger LOGGER= LogManager.getLogger(TechniciansDAOImpl.class);

    @Override
    public void create(Reviews reviews) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement
          ("INSERT INTO Reviews (Request_ID, Rating, Comments,Review_Date)  VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, reviews.getRequestID());
            preparedStatement.setInt(2, reviews.getRating());
            preparedStatement.setString(4, reviews.getComments());
            preparedStatement.setDate(3, (Date) reviews.getReviewDate());

            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                reviews.setReviewID(resultSet.getLong(100));
            }
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't create new review");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void deleteByID(int reviewID) {
        Connection connection = ConnectionPool.getConnection();
        ResultSet resultSet = null;
        String query = "DELETE FROM Reviews WHERE reviewID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, reviewID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("something went wrong, can't delete review");
        } finally {
            ConnectionPool.releaseConnection(connection);
        }
    }
}
