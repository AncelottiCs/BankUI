package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String DB_URL = "jdbc:sqlite:final_project.db";
    private static DataBaseConnection instance;
    Connection connection;

    // Private constructor to prevent instantiation
    private DataBaseConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Successfully connected to SQLite database");
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }

    // Public method to get the singleton instance
    public static synchronized DataBaseConnection getInstance() {
        if (instance == null) {
            instance = new DataBaseConnection();
        }
        return instance;
    }

    public ResultSet getById(int id) throws SQLException {
        return instance.connection.createStatement().executeQuery("SELECT * FROM users WHERE id = " + id);
    }

    public void updateBalance(int id, int balance) throws SQLException {
        instance.connection.createStatement().executeUpdate("UPDATE users SET balance = " + balance + " WHERE id = " + id);
    }

    public ResultSet login(String username, String password) throws SQLException {
        return instance.connection.createStatement().executeQuery("SELECT * FROM users WHERE fname = '" + username + "' AND password = '" + password + "'");
    }
}
