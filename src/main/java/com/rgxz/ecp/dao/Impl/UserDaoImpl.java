package com.rgxz.ecp.dao.Impl;

import com.rgxz.ecp.dao.IUserDao;
import com.rgxz.ecp.entity.User;
import com.rgxz.ecp.mysql.ConnectMysql;

import java.sql.*;

public class UserDaoImpl implements IUserDao {
    @Override
    public boolean add(User user) {
        String sqlInsert = "insert into user(name, pwd, address, balance, gender, image_url, identity) value (?,?,?,?,?,?,?)";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection==null)return false;
        try {
            connection.setAutoCommit(true);
            ps = connection.prepareStatement(sqlInsert);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPwd());
            ps.setString(3, user.getAddress());
            ps.setFloat(4, user.getBalance());
            ps.setString(5, user.getGender());
            ps.setString(6, user.getImage_url());
            ps.setInt(7, user.getIdentity());
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectMysql.closeConnect(connection);
            ConnectMysql.closePs(ps);
            ConnectMysql.closeRs(rs);
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean updateBusinessId(int business_id, String user_name) {
        String sqlUpdate = "update user set business_id = ? where name = ?";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection==null)return false;
        try {
            connection.setAutoCommit(true);
            ps = connection.prepareStatement(sqlUpdate);
            ps.setInt(1, business_id);
            ps.setString(2, user_name);
            ps.executeUpdate();
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectMysql.closeConnect(connection);
            ConnectMysql.closePs(ps);
            ConnectMysql.closeRs(rs);
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

    public User createUser(ResultSet rs) throws SQLException{
        User user = new User();
        user.setId(rs.getInt(1));
        user.setName(rs.getString(2));
        user.setPwd(rs.getString(3));
        user.setAddress(rs.getString(4));
        user.setPhone(rs.getString(5));
        user.setBalance(rs.getFloat(6));
        user.setGender(rs.getString(7));
        user.setImage_url(rs.getString(8));
        user.setIdentity(rs.getInt(9));
        user.setBusiness_id(rs.getInt(10));
        user.setCreate_time(rs.getTimestamp(11));
        return user;
    }
}
