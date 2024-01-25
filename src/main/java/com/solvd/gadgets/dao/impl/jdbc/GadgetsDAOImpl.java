package com.solvd.gadgets.dao.impl.jdbc;

import com.solvd.gadgets.bin.Gadgets;
import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.dao.GadgetsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GadgetsDAOImpl implements GadgetsDAO {


    @Override
    public Gadgets getGadgetById(int gadgetId) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Gadgets WHERE gadget_id = ?")) {
            preparedStatement.setInt(1, gadgetId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Gadgets> getAllGadgets() {
        return null;
    }

    @Override
    public void create(Gadgets gadget) {

    }

    @Override
    public void update(Gadgets gadgetId) {

    }

    @Override
    public void delete(Gadgets gadgetId) {

    }

}
