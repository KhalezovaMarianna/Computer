package com.solvd.jdbc;

import com.solvd.classes.Garages;
import com.solvd.dao.IGarageDAO;
import connectionPool.AbstractClassJDBC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class GarageDAO extends AbstractClassJDBC implements IGarageDAO {
    private static final Logger LOGGER = LogManager.getLogger(GarageDAO.class);
    private Connection connection = null;
    private ResultSet resultSet = null;
    private Garages g = new Garages();
    private PreparedStatement pr = null;

    @Override
    public List<Garages> getAllGarages() {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from Garages");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                g.setIdGarage(resultSet.getInt("2"));
                g.setAdress(resultSet.getString("adress"));
                g.setMaxWorkers(resultSet.getInt("maxWorkers"));
                LOGGER.info(g);
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            getConnectionPool().returnConnection(connection);
            try {
                if (pr != null) {
                    pr.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                LOGGER.info(e);

            }
        }
        return getAllGarages();
    }

    @Override
    public Garages getEntityById(int id) throws SQLException {
        return null;
    }

    @Override
    public void save(Garages entity) throws SQLException {

    }

    @Override
    public void createEntity(Garages entity) {

    }

    @Override
    public void updateEntity(Garages entity) {

    }

    @Override
    public void removeEntity(Garages entity) throws SQLException {

    }

    @Override
    public void findById(int id) throws SQLException {

    }
}
