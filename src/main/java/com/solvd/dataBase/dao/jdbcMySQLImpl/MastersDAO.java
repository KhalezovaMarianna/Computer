package com.solvd.dataBase.dao.jdbcMySQLImpl;

import com.solvd.dataBase.dao.IMasterDAO;
import com.solvd.dataBase.dao.connectionPool.ConnectionPool;
import com.solvd.dataBase.models.Diagnosts;
import com.solvd.dataBase.models.Masters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sound.midi.MidiMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MastersDAO implements IMasterDAO {
    private static final Logger LOGGER = LogManager.getLogger(MastersDAO.class);
    private static final Properties p = new Properties();
    private final Masters masters = new Masters();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;

    @Override
    public List<Masters> getAllMasters() {
        List<Masters> masters = new ArrayList<>();
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from masters");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                Masters master = new Masters();
                master.setIdMasters(resultSet.getInt("id"));
                master.setName(resultSet.getString("name"));
                master.setFirstName(resultSet.getString("firstName"));
                master.setTelefonNumber(resultSet.getString("telefonNumber"));
                masters.add(master);
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
        return masters;
    }


    @Override
    public Masters getEntityById(int idMasters) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from Masters where id=?");
            pr.setInt(1, idMasters);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                masters.setIdMasters(resultSet.getInt("id"));
                masters.setName(resultSet.getString("name"));
                masters.setFirstName(resultSet.getString("firstName"));
                masters.setTelefonNumber(resultSet.getString("telefonNumber"));
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
        return masters;
    }

    @Override
    public void saveEntity(Masters entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Insert into masters (name,firstName,telefonNumber) Values (?,?,?)");
            pr.setString(1, entity.getName());
            pr.setString(2, entity.getFirstName());
            pr.setString(3, entity.getTelefonNumber());
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
    public void updateEntity(Masters entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Update masters Set name=?,firstName=?,telefonNumber=? where idMasters=?");
            pr.setString(1, entity.getName());
            pr.setString(2, entity.getFirstName());
            pr.setString(3, entity.getTelefonNumber());
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
    public void removeEntity(Masters entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from Masters where idMasters=?");
            pr.setInt(1, entity.getIdMasters());
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
