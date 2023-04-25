package com.rgxz.ecp.dao.Impl;

import com.rgxz.ecp.dao.IGoodsDao;
import com.rgxz.ecp.entity.Goods;
import com.rgxz.ecp.mysql.ConnectMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsDaoImpl implements IGoodsDao {
    @Override
    public boolean add(Goods goods) {
//        String sqlFindGoodsId = "select id from goods where name = ?";
//        String sqlFindBusinessId = "select id from business where name = ?";
//        String sqlFindTypeId = "select id from type where name = ?";
//        String sqlFindRes = "select id from supply where business_id = ? AND goods_id = ?";
//        String sqlInsert = "insert into supply(goods_id, business_id, type_id, price, amount, date, image_url, refer) values (?,?,?,?,?,?,?,?)";
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        Connection connection = ConnectMysql.getConnect();
//        if (connection==null)return false;
//        try {
//            ps = connection.prepareStatement(sqlFindGoodsId);
//            ps.setString(1, goods.getName());
//            rs = ps.executeQuery();
//            if (!rs.next()) return false;
//            int goodsId = rs.getInt(1);
//
//            ps = connection.prepareStatement(sqlFindBusinessId);
//            ps.setString(1, goods.getBusiness());
//            rs = ps.executeQuery();
//            if (!rs.next()) return false;
//            int businessId = rs.getInt(1);
//
//            ps = connection.prepareStatement(sqlFindTypeId);
//            ps.setString(1, goods.getType());
//            rs = ps.executeQuery();
//            if (!rs.next()) return false;
//            int typeId = rs.getInt(1);
//
//            ps = connection.prepareStatement(sqlFindRes);
//            ps.setInt(1, businessId);
//            ps.setInt(2, goodsId);
//            rs = ps.executeQuery();
//            if (rs.next()) return false;
//
//            ps = connection.prepareStatement(sqlInsert);
//            ps.setInt(1, goodsId);
//            ps.setInt(2, businessId);
//            ps.setInt(3, typeId);
//            ps.setFloat(4, goods.getPrice());
//            ps.setInt(5, goods.getAmount());
//            ps.setDate(6, goods.getDate());
//            ps.setString(7, goods.getImage_url());
//            ps.setString(8, goods.getDescribe());
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            ConnectMysql.closeConnect(connection);
//            ConnectMysql.closePs(ps);
//            ConnectMysql.closeRs(rs);
//        }
        return false;
    }

    @Override
    public boolean delete(Goods goods) {
        return false;
    }

    @Override
    public boolean update(Goods goods) {
        return false;
    }

    @Override
    public Goods find(String goodsName, String businessName) {
        return null;
    }
}
