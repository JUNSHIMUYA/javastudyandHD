package com.zhang.weblog.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DbUtils
 * 作用：JDBC工具类
 */
public class DbUtils {

    private static Connection connection = null;
    private final static String URL = "jdbc:mysql://localhost:3306/web_log_view?useUnicode=true&characterEncoding=utf8";
    private final static String USER = "root";
    private final static String PASSWD = "root";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection openConn() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static void closeConn() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}