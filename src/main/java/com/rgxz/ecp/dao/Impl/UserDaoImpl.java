package com.rgxz.ecp.dao.Impl;

import com.rgxz.ecp.dao.IUserDao;
import com.rgxz.ecp.entity.User;
import com.rgxz.ecp.mysql.ConnectMysql;

import java.sql.*;

public class UserDaoImpl implements IUserDao {
    @Override
    public boolean add(User user) {
        String sqlInsert = "insert into user(name, pwd, address, phone, ip) value (?,?,?,?,?)";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        if (connection==null)return false;
        try {
            connection.setAutoCommit(true);
            ps = connection.prepareStatement(sqlInsert);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPwd());
            ps.setString(3, user.getAddress());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getIp());
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectMysql.closeConnect(connection);
            ConnectMysql.closePs(ps);
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean updateIsBusiness(int id, Boolean is_business) {
        String sqlUpdate = "update user set is_business=? where id=?";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        if (connection==null)return false;
        try {
            connection.setAutoCommit(true);
            ps = connection.prepareStatement(sqlUpdate);
            ps.setBoolean(1, is_business);
            ps.setInt(2, id);
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectMysql.closeConnect(connection);
            ConnectMysql.closePs(ps);
        }
        return false;
    }

    @Override
    public User findUser(String name) {
        String sqlFindUser = "select * from user where name = ?";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection==null)return null;
        try {
            ps = connection.prepareStatement(sqlFindUser);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (!rs.next()) return null;
            return createUser(rs);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectMysql.closeConnect(connection);
            ConnectMysql.closePs(ps);
            ConnectMysql.closeRs(rs);
        }
        return null;
    }

    @Override
    public String findPwd(String name) {
        String sqlFindPwd = "select pwd from user where name = ?";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection==null)return null;
        try {
            ps = connection.prepareStatement(sqlFindPwd);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (!rs.next()) return null;
            return rs.getString(1);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectMysql.closeConnect(connection);
            ConnectMysql.closePs(ps);
            ConnectMysql.closeRs(rs);
        }
        return null;
    }

    @Override
    public Integer findId(String name) {
        String sqlFindPwd = "select id from user where name = ?";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection==null)return null;
        try {
            ps = connection.prepareStatement(sqlFindPwd);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (!rs.next()) return null;
            return rs.getInt(1);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectMysql.closeConnect(connection);
            ConnectMysql.closePs(ps);
            ConnectMysql.closeRs(rs);
        }
        return null;
    }

    public User createUser(ResultSet rs) throws SQLException{
        User user = new User();
        user.setId(rs.getInt(1));
        user.setName(rs.getString(2));
        user.setPwd(rs.getString(3));
        user.setIs_business(rs.getBoolean(4));
        user.setAddress(rs.getString(5));
        user.setPhone(rs.getString(6));
        user.setBalance(rs.getFloat(7));
        user.setGender(rs.getString(8));
        user.setImage_url(rs.getString(9));
        user.setIdentity(rs.getInt(10));
        user.setIp(rs.getString(11));
        user.setCreate_time(rs.getTimestamp(12));
        return user;
    }
}
