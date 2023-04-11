package com.rgxz.ecp.dao.Impl;

import com.rgxz.ecp.dao.IBusinessDao;
import com.rgxz.ecp.entity.Business;
import com.rgxz.ecp.mysql.ConnectMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusinessDaoImpl implements IBusinessDao {
    @Override
    public boolean add(Business business) {
        String sqlInsert = "insert into business(name, address, phone, introduce, image_url) value (?,?,?,?,?)";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection==null)return false;
        try {
            connection.setAutoCommit(true);
            ps = connection.prepareStatement(sqlInsert);
            ps.setString(1, business.getName());
            ps.setString(2, business.getAddress());
            ps.setString(3, business.getPhone());
            ps.setString(4, business.getIntroduce());
            ps.setString(5, business.getImage_url());
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
    public boolean delete(Business business) {
        return false;
    }

    @Override
    public boolean update(Business business) {
        return false;
    }

    @Override
    public Business find(String businessName) {
        return null;
    }
}
