package com.solvd.dataBase.dao.jdbcMySQLImpl;

import com.solvd.dataBase.dao.connectionPool.ConnectionPool;
import com.solvd.dataBase.models.Autos;
import com.solvd.dataBase.dao.IAutoDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AutoDAO  implements IAutoDAO {
    private static final Logger LOGGER = LogManager.getLogger(AutoDAO.class);
    private static final Properties p = new Properties();
    private final Autos autos = new Autos("BMW");
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;

    @Override
    public List<Autos> getAllAutos() {
        List<Autos> auto = new ArrayList<>();
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from auto");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                autos.setStateNumber(resultSet.getInt("stateNumber"));
                autos.setModel(resultSet.getString("name"));
                auto.add(autos);
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
        return auto;
    }

    @Override
    public Autos getEntityById(int stateNumber) throws SQLException {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from auto where id=?");
            pr.setInt(1, stateNumber);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                autos.setStateNumber(resultSet.getInt("stateNumber"));
                autos.setModel(resultSet.getString("model"));
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
        return autos;
    }


    @Override
    public void saveEntity(Autos entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Insert into auto (model) Values (?)");
            pr.setString(1, entity.getModel());
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
    public void updateEntity(Autos entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Update auto Set model=? where stateNumber=?");
            pr.setString(1, entity.getModel());
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
    public void removeEntity(Autos entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from auto where stateNumber=?");
            pr.setInt(1, entity.getStateNumber());
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
