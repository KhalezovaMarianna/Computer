package com.solvd.serviceStation.dao.jdbcMySQLImpl;

import com.solvd.serviceStation.classes.Garages;
import com.solvd.serviceStation.dao.connectionPool.AbstractClassJDBC;
import com.solvd.serviceStation.dao.IGarageDAO;
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
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from Garages  where id=?");
            pr.setInt(1, id);
            pr.execute();
            LOGGER.info("it is a select");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {

            getConnectionPool().returnConnection(connection);
            try {
                if (pr != null) {
                    pr.close();
                }
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
        return getEntityById(1);
    }


    @Override
    public void createEntity(Garages entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("insert into Garages(maxWorkers) values (?)");
            resultSet = pr.getResultSet();
            pr.setInt(1, resultSet.getInt("maxWorkers"));
            pr.execute();
            LOGGER.info("has been insert");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {

            getConnectionPool().returnConnection(connection);
            try {
                if (pr != null) {
                    pr.close();
                }
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void updateEntity(Garages entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("update Garages set adress=?,maxWorkers=? where id=?");
            pr.setString(1, entity.getAdress());
            pr.setInt(2, entity.getMaxWorkers());
            pr.setInt(3, entity.getIdGarage());
            pr.executeUpdate();
            LOGGER.info("Garages data has been update");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {

            getConnectionPool().returnConnection(connection);
            try {
                if (pr != null) {
                    pr.close();
                }
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void removeEntity(Garages entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("delete from Garages where id=?");
            pr.setInt(1, entity.getIdGarage());
            pr.executeUpdate();
            LOGGER.info("Garages data has been delete");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {

            getConnectionPool().returnConnection(connection);
            try {
                if (pr != null) {
                    pr.close();
                }
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }

    }

}
