package com.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static String DRIVER = "";
    private static String URL = "";
    private static String USERNAME = "";
    private static String PASSWORD = "";
    private Connection conn = null;

    static {
        try(InputStream is = DBConnection.class.getResourceAsStream("database.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            DRIVER = properties.getProperty("DRIVER");
            URL = properties.getProperty("URL");
            USERNAME = properties.getProperty("USERNAME");
            PASSWORD = properties.getProperty("PASSWORD");
        } catch (IOException e) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public DBConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException throwables) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, throwables);
        }
    }
}
