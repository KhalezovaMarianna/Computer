package com.solvd.dataBase.dao.jdbcMySQLImpl;

import com.solvd.dataBase.classes.TimeToWork;
import com.solvd.dataBase.dao.ITimeToWorkDAO;
import com.solvd.dataBase.dao.connectionPool.AbstractClassJDBC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TimeToWorkDAO extends AbstractClassJDBC implements ITimeToWorkDAO {
    private static final Logger LOGGER = LogManager.getLogger(TimeToWorkDAO.class);
    private Connection connection = null;
    private ResultSet resultSet = null;
    private TimeToWork t = new TimeToWork(1,1.5);
    private PreparedStatement pr = null;

    public static List<TimeToWork> getTimeToWork() {
        return getTimeToWork();
    }

    @Override
    public List<TimeToWork> getAllTimeToWork() {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from TimeToWork");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                t.setIdTime(resultSet.getInt("2"));
                t.setTimeToWork(resultSet.getDouble("timeToWork"));
                LOGGER.info(t);
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
        return getAllTimeToWork();
    }

    @Override
    public TimeToWork getEntityById(int id) throws SQLException {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from TimeToWork  where id=?");
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
    public void saveEntity(TimeToWork entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("insert into TimeToWork(timeToWork) values (?)");
            resultSet = pr.getResultSet();
            pr.setInt(1, resultSet.getInt("timeToWork"));
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
    public void updateEntity(TimeToWork entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("update TimeToWork set timeToWork=? where id=?");
            pr.setDouble(1, entity.getTimeToWork());
            pr.setInt(2, entity.getIdTime());
            pr.executeUpdate();
            LOGGER.info("TimeToWork data has been update");
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
    public void removeEntity(TimeToWork entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("delete from TimeToWork where id=?");
            pr.setInt(1, entity.getIdTime());
            pr.executeUpdate();
            LOGGER.info("TimeToWork data has been delete");
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


