package com.solvd.gadgets.dao.impl.jdbc;

import com.solvd.gadgets.bin.Gadgets;
import com.solvd.gadgets.connection.ConnectionPool;
import com.solvd.gadgets.dao.daoInterfaces.GadgetsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class GadgetsDAOImpl implements GadgetsDAO {
    private static final Logger LOGGER= LogManager.getLogger(TechniciansDAOImpl.class);


    @Override
    public Optional<Gadgets> getGadgetById(int gadgetId) {
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
        return Optional.empty();
    }

    @Override
    public List<Gadgets> getAllGadgets() {
        return null;
    }

    @Override
    public void create(Gadgets gadget) {

    }

    @Override
    public void delete(int gadgetId) {

    }


}
