package com.solvd.dao;

import com.solvd.classes.Garages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class GaragesDAO implements IGarageDAO {
    private static final Logger LOGGER = LogManager.getLogger(GaragesDAO.class);
    Connection connection = null;
    ResultSet resultSet = null;

    @Override
    public void save(Garages garages) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/Service",
                "root", "devintern");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Garages (idGarage, adress, maxWorkers) VALUES (?, ?, ?)");
        preparedStatement.setInt(1, 234);
        preparedStatement.setString(2, garages.getAdress());
        preparedStatement.setInt(3, garages.getMaxWorkers());
        preparedStatement.executeUpdate();
    }

    @Override
    public void findById(int id) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://52.59.193.212:3306/Service",
                "root", "devintern");
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM Garages WHERE idGarage = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            LOGGER.info(resultSet.getString("idGarage"));
            LOGGER.info(resultSet.getString("adress"));
            LOGGER.info(resultSet.getString("maxWorkers"));
        }

    }
}
