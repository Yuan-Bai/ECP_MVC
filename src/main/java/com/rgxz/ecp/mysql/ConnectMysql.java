package com.rgxz.ecp.mysql;

import java.sql.*;

public class ConnectMysql {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnect(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/shop?user=root&password=yuanbai233&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnect(Connection connection){
        if (null != connection){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closePs(PreparedStatement ps){
        if (null != ps){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeRs(ResultSet rs){
        if (null != rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
