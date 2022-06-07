package com.solvd.dataBase.dao.jdbcMySQLImpl;

import com.solvd.dataBase.dao.connectionPool.ConnectionPool;
import com.solvd.dataBase.models.Diagnosts;
import com.solvd.dataBase.models.Garages;
import com.solvd.dataBase.dao.IGarageDAO;
import com.solvd.dataBase.models.TimeToWork;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GarageDAO implements IGarageDAO {
    private static final Logger LOGGER = LogManager.getLogger(GarageDAO.class);
    private static final Properties p = new Properties();
    private final Garages garages = new Garages();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;

    @Override
    public List<Garages> getAllGarages() {
        List<Garages> garage = new ArrayList<>();
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from garages");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                Garages garages = new Garages();
                garages.setIdGarage(resultSet.getInt("idGarage"));
                garages.setAdress(resultSet.getString("adress"));
                garages.setMaxWorkers(resultSet.getInt("maxWorkers"));
                garage.add(garages);
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
        return garage;
    }

    @Override
    public Garages getEntityById(int idGarage) throws SQLException {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from Garages where idGarage=?");
            pr.setInt(1, idGarage);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
               garages.setIdGarage(resultSet.getInt("idGarage"));
                garages.setAdress(resultSet.getString("adress"));
                garages.setMaxWorkers(resultSet.getInt("maxWorkers"));
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
        return garages;
    }


    @Override
    public void saveEntity(Garages entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Insert into garages (adress,maxWorkers) Values (?,?)");
            pr.setString(1, entity.getAdress());
            pr.setInt(2, entity.getMaxWorkers());
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
    public void updateEntity(Garages entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Update garages Set adress=?,maxWorkers=? where idGarage=?");
            pr.setString(1, entity.getAdress());
            pr.setInt(2, entity.getMaxWorkers());
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
    public void removeEntity(Garages entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from Garages where idGarage=?");
            pr.setInt(1, entity.getIdGarage());
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
