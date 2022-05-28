package com.solvd.serviceStation.dao.jdbcMySQLImpl;

import com.solvd.serviceStation.classes.Autos;
import com.solvd.serviceStation.dao.IAutoDAO;
import com.solvd.serviceStation.dao.connectionPool.AbstractClassJDBC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AutoDAO extends AbstractClassJDBC implements IAutoDAO {
    private static final Logger LOGGER = LogManager.getLogger(AutoDAO.class);
    private Connection connection = null;
    private ResultSet resultSet = null;
    private Autos a = new Autos();
    private PreparedStatement pr = null;

    @Override
    public List<Autos> getAllAutos() {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from Autos");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                a.setStateNumber(resultSet.getInt("2"));
                a.setModel(resultSet.getString("adress"));
                LOGGER.info(a);
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
        return getAllAutos();
    }

    @Override
    public Autos getEntityById(int id) throws SQLException {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from Autos  where id=?");
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
    public void createEntity(Autos entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("insert into Autos(model) values (?)");
            resultSet = pr.getResultSet();
            pr.setInt(1, resultSet.getInt("model"));
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
    public void updateEntity(Autos entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("update Autos set model=? where id=?");
            pr.setString(1, entity.getModel());
            pr.setInt(2, entity.getStateNumber());
            pr.executeUpdate();
            LOGGER.info("Autos data has been update");
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
    public void removeEntity(Autos entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("delete from Autos where id=?");
            pr.setInt(1, entity.getStateNumber());
            pr.executeUpdate();
            LOGGER.info("Autos data has been delete");
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
