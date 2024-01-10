package com.solvd.gadgets.dao.impl;

import com.solvd.gadgets.bin.Gadgets;
import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.dao.GadgetsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GadgetsDaoImpl implements GadgetsDao {


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
    public void addGadget(Gadgets gadget) {

    }

    @Override
    public void updateGadget(Gadgets gadget) {

    }

    @Override
    public void deleteGadget(int gadgetId) {

    }
}
