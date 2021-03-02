package com.kangjiaqi;

import java.sql.*;
import java.util.ResourceBundle;

public class JDUtil {
    static String URL = "";
    static String USER = "";
    static String PASSWORD = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ResourceBundle rb = ResourceBundle.getBundle("cfg");
        String mysqlIp = rb.getString("mysqlIp");
        String mysqlPort = rb.getString("mysqlPort");
        String database = rb.getString("database");
        String username = rb.getString("username");
        String password = rb.getString("password");

        URL = String.format("jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Shanghai", mysqlIp, mysqlPort, database);
        USER = username;
        PASSWORD = password;
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
