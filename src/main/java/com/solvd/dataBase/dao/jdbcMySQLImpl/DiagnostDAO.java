package com.solvd.dataBase.dao.jdbcMySQLImpl;

import com.solvd.dataBase.dao.IDiagnostDAO;
import com.solvd.dataBase.dao.connectionPool.ConnectionPool;
import com.solvd.dataBase.models.Diagnosts;
import com.solvd.dataBase.models.TimeToWork;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DiagnostDAO implements IDiagnostDAO {
    private static final Logger LOGGER = LogManager.getLogger(DiagnostDAO.class);
    private static final Properties p = new Properties();
    private final Diagnosts diagnosts = new Diagnosts();
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;

    @Override
    public List<Diagnosts> getAllDiagnosts() {
        List<Diagnosts> diagnosts = new ArrayList<>();
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from diagnosts");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                Diagnosts diagnost = new Diagnosts();
                diagnost.setIdDiagnosts(resultSet.getInt("id"));
                diagnost.setName(resultSet.getString("name"));
                diagnost.setFirstName(resultSet.getString("firstName"));
                diagnost.setTelefonNumber(resultSet.getString("telefonNumber"));
                diagnosts.add(diagnost);
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
        return diagnosts;
    }


    @Override
    public Diagnosts getEntityById(int idDiagnosts) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Select * from Diagnosts where idDiagnosts=?");
            pr.setInt(1, idDiagnosts);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                diagnosts.setIdDiagnosts(resultSet.getInt("id"));
                diagnosts.setName(resultSet.getString("name"));
                diagnosts.setFirstName(resultSet.getString("firstName"));
                diagnosts.setTelefonNumber(resultSet.getString("telefonNumber"));
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
        return diagnosts;
    }

    @Override
    public void saveEntity(Diagnosts entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Insert into diagnosts (name,firstName,telefonNumber) Values (?,?,?)");
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
    public void updateEntity(Diagnosts entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement
                    ("Update diagnosts Set name=?,firstName=?,telefonNumber=? where idDiagnosts=?");
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
    public void removeEntity(Diagnosts entity) {
        try {
            connection = connectionPool.retrieve();
            pr = connection.prepareStatement("Delete from Diagnosts where idDiagnosts=?");
            pr.setInt(1, entity.getIdDiagnosts());
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

