package com.solvd.dataBase.dao.connectionPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static final int CON_POOL_SIZE = 5;
    private static Properties p = new Properties();
    private static final String username;
    private static final String url;
    private static final String password;
    private Vector<Connection> conPool = new Vector<>(CON_POOL_SIZE, 1);
    private Vector<Connection> activeConnections = new Stack<>();

    private ConnectionPool() {
        for (int i = 0; i < CON_POOL_SIZE; i++) {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                LOGGER.info(e);
            }
            conPool.add(connection);
        }
    }

    private static ConnectionPool instance = null;

    public static ConnectionPool getInstance() {
        if (instance == null) instance = new ConnectionPool();
        return instance;
    }

    static {
        try (FileInputStream f = new FileInputStream("src/main/resources/db.properties")) {
            p.load(f);
        } catch (IOException e) {
            LOGGER.info(e);
        }
        url = p.getProperty("db.url");
        username = p.getProperty("db.username");
        password = p.getProperty("db.password");
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return conn;
    }

    public synchronized Connection retrieve() {
        Connection newConn = null;
        if (conPool.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = (Connection) conPool.lastElement();
            conPool.removeElement(newConn);
        }
        activeConnections.addElement(newConn);
        LOGGER.info("The connection was retrieved: " + newConn.toString());
        return newConn;
    }

    public synchronized void putback(Connection c) {
        if (c != null) {
            if (activeConnections.removeElement(c)) {
                conPool.addElement(c);
                LOGGER.info("Putting the connection back to Connection pool: " + c.toString());
            } else {
                throw new NullPointerException("Connection is not in the Active Connections array");
            }
        }
    }
}
