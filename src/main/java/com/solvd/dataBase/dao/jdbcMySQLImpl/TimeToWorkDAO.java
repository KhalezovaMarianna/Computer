package com.solvd.dataBase.dao.jdbcMySQLImpl;

import com.solvd.dataBase.dao.connectionPool.ConnectionPool;
import com.solvd.dataBase.models.Autos;
import com.solvd.dataBase.models.TimeToWork;
import com.solvd.dataBase.dao.ITimeToWorkDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TimeToWorkDAO implements ITimeToWorkDAO {
    private static final Logger LOGGER = LogManager.getLogger(TimeToWorkDAO.class);
    private static final Properties p = new Properties();
    private final TimeToWork timeToWork = new TimeToWork(1,2.5);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;

    @Override
    public List<TimeToWork> getAllTimeToWork() {
        List<TimeToWork> timeToWorks = new ArrayList<>();
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from TimeToWork");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                timeToWork.setIdTime(resultSet.getInt("idTime"));
                timeToWork.setTimeToWork(resultSet.getDouble("name"));
                timeToWorks.add(timeToWork);
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connectionPool.putback(connection);
                if (resultSet != null) resultSet.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
        return timeToWorks;
    }

    @Override
    public TimeToWork getEntityById(int idTime) throws SQLException {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from TimeToWork where idTime=?");
            pr.setInt(1, idTime);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                timeToWork.setIdTime(resultSet.getInt("idTime"));
                timeToWork.setTimeToWork(resultSet.getDouble("timeToWork"));
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connectionPool.putback(connection);
                if (resultSet != null) resultSet.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
        return timeToWork;
    }


    @Override
    public void saveEntity(TimeToWork entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Insert into TimeToWork (timeToWork) Values (?)");
            pr.setDouble(1, entity.getTimeToWork());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connectionPool.putback(connection);
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }


    @Override
    public void updateEntity(TimeToWork entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Update TimeToWork Set timeToWork=? where idTime=?");
            pr.setDouble(1, entity.getTimeToWork());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connectionPool.putback(connection);
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void removeEntity(TimeToWork entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from TimeToWork where idTime=?");
            pr.setInt(1, entity.getIdTime());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connectionPool.putback(connection);
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }
}


