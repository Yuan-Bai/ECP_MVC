package com.rgxz.ecp.dao.Impl;

import com.rgxz.ecp.dao.IBusinessDao;
import com.rgxz.ecp.entity.Business;
import com.rgxz.ecp.entity.User;
import com.rgxz.ecp.mysql.ConnectMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessDaoImpl implements IBusinessDao {
    @Override
    public boolean add(Business business) {
        String sqlInsert = "insert into business(user_id, name, address, phone, image_url) value (?,?,?,?,?)";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        if (connection==null)return false;
        try {
            connection.setAutoCommit(true);
            ps = connection.prepareStatement(sqlInsert);
            ps.setInt(1, business.getUser_id());
            ps.setString(2, business.getName());
            ps.setString(3, business.getAddress());
            ps.setString(4, business.getPhone());
            ps.setString(5, business.getImage_url());
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
    public boolean delete(Business business) {
        return false;
    }

    @Override
    public boolean update(Business business) {
        return false;
    }

    @Override
    public Business findByName(String businessName) {
        return null;
    }

    @Override
    public Business findByUserId(int user_id) {
        String sqlFindById = "select * from business where user_id = ?";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection==null)return null;
        try {
            ps = connection.prepareStatement(sqlFindById);
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            if (!rs.next()) return null;
            return createBusiness(rs);
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectMysql.closeConnect(connection);
            ConnectMysql.closePs(ps);
            ConnectMysql.closeRs(rs);
        }
        return null;
    }

    public Business createBusiness(ResultSet rs) throws SQLException{
        Business business = new Business();
        business.setId(rs.getInt(1));
        business.setUser_id(rs.getInt(2));
        business.setName(rs.getString(3));
        business.setAddress(rs.getString(4));
        business.setPhone(rs.getString(5));
        business.setCredit(rs.getInt(6));
        business.setIntroduce(rs.getString(7));
        business.setImage_url(rs.getString(8));
        business.setCreate_time(rs.getTimestamp(9));
        return business;
    }
}
