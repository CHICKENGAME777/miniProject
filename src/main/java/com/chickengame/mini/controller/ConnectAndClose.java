package com.chickengame.mini.controller;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectAndClose {
    private Connection con = null;
    private static ConnectAndClose instance = new ConnectAndClose();

    private ConnectAndClose() {
    }

    public static ConnectAndClose getInstance() {
        return instance;
    }

    public Connection getConnection() {
        if (con == null) {
            Properties prop = new Properties();
            try {
                prop.load(new FileReader("src/main/java/com/chickengame/mini/config/connection-info.properties"));
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                Class.forName(driver);
                con = DriverManager.getConnection(url, prop);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return con;
    }

    public void close(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(Statement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close(ResultSet rset) {
        try {
            if (rset != null && !rset.isClosed()) {
                rset.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
