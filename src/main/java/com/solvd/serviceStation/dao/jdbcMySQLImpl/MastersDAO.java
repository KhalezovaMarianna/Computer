package com.solvd.serviceStation.dao.jdbcMySQLImpl;

import com.solvd.serviceStation.dao.IMasterDAO;
import com.solvd.serviceStation.classes.Masters;
import com.solvd.serviceStation.dao.connectionPool.AbstractClassJDBC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MastersDAO extends AbstractClassJDBC implements IMasterDAO {
    private static final Logger LOGGER = LogManager.getLogger(MastersDAO.class);
    private Connection connection = null;
    private ResultSet resultSet = null;
    private Masters m = new Masters();
    private PreparedStatement pr = null;

    @Override
    public List<Masters> getAllMasters() {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from Masters");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                m.setIdMasters(resultSet.getInt("2"));
                m.setName(resultSet.getString("name"));
                m.setFirstName(resultSet.getString("firstName"));
                m.setTelefonNumber(resultSet.getString("telefonNumber"));
                LOGGER.info(m);
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
        return getAllMasters();
    }
    @Override
    public Masters getEntityById(int id) throws SQLException {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from Masters  where id=?");
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
    public void createEntity(Masters entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("insert into Masters(firstName) values (?)");
            resultSet = pr.getResultSet();
            pr.setInt(1, resultSet.getInt("firstName"));
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
    public void updateEntity(Masters entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("update Masters set name=?,firstName=?,telefonNumber=? where id=?");
            pr.setString(1, entity.getName());
            pr.setString(2, entity.getFirstName());
            pr.setString(3, entity.getTelefonNumber());
            pr.setInt(4, entity.getIdMasters());
            pr.executeUpdate();
            LOGGER.info("Masters data has been update");
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
    public void removeEntity(Masters entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("delete from Masters where id=?");
            pr.setInt(1, entity.getIdMasters());
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
