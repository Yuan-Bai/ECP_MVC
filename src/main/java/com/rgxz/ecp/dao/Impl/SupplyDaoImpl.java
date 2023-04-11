package com.rgxz.ecp.dao.Impl;

import com.rgxz.ecp.dao.ISupplyDao;
import com.rgxz.ecp.entity.Supply;
import com.rgxz.ecp.mysql.ConnectMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class SupplyDaoImpl implements ISupplyDao {
    @Override
    public boolean add(Supply supply) {
        String sqlInsert = "insert into shop.supply(goods_name, business_id, price, amount, image_url, introduce, type) value (?,?,?,?,?,?,?)";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection==null)return false;
        try {
            connection.setAutoCommit(true);
            ps = connection.prepareStatement(sqlInsert);
            ps.setString(1, supply.getGoods_name());
            ps.setInt(2, supply.getBusiness_id());
            ps.setFloat(3, supply.getPrice());
            ps.setInt(4, supply.getAmount());
            ps.setString(5, supply.getImage_url());
            ps.setString(6, supply.getIntroduce());
            ps.setString(7, supply.getType());
            ps.executeUpdate();
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
//          todo 后期去掉打印输出
            System.out.println("用户名重复");
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
    public boolean delete(Supply supply) {
        return false;
    }

    @Override
    public boolean update(Supply supply) {
        return false;
    }

    @Override
    public ArrayList<String> findType() {
        String sqlFind = "select type from supply";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection==null)return null;
        try {
            ps = connection.prepareStatement(sqlFind);
            rs = ps.executeQuery();
            ArrayList<String> type_array = new ArrayList<>();
            while (rs.next()){
                type_array.add(rs.getString(1));
            }
            return type_array;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectMysql.closeConnect(connection);
            ConnectMysql.closePs(ps);
            ConnectMysql.closeRs(rs);
        }
        return null;
    }

    @Override
    public Supply findGoods(Integer id) {
        String sqlFind = "select * from supply where id = ?";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection==null)return null;
        try {
            ps = connection.prepareStatement(sqlFind);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) return null;
            return createSupply(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectMysql.closeConnect(connection);
            ConnectMysql.closePs(ps);
            ConnectMysql.closeRs(rs);
        }
        return null;
    }

    @Override
    public Supply findGoods() {
        String sqlFind = "select * from supply where id = ?";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection==null)return null;
        try {
            String sqlGetMaxId = "select count(id) from supply";
            ps = connection.prepareStatement(sqlGetMaxId);
            rs = ps.executeQuery();
            if (!rs.next()) return null;
            Random random = new Random();
            int id = random.nextInt(rs.getInt(1))+1;
            ps = connection.prepareStatement(sqlFind);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) return null;
            return createSupply(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectMysql.closeConnect(connection);
            ConnectMysql.closePs(ps);
            ConnectMysql.closeRs(rs);
        }
        return null;
    }

    @Override
    public ArrayList<Supply> findGoods(String goods_name) {
        String sqlFind = "select * from supply where goods_name = ?";
        Connection connection = ConnectMysql.getConnect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (connection==null)return null;
        try {
            ps = connection.prepareStatement(sqlFind);
            ps.setString(1, goods_name);
            rs = ps.executeQuery();
            ArrayList<Supply> supply_array = new ArrayList<>();
            while (rs.next()){
                supply_array.add(createSupply(rs));
            }
            return supply_array;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectMysql.closeConnect(connection);
            ConnectMysql.closePs(ps);
            ConnectMysql.closeRs(rs);
        }
        return null;
    }

    public Supply createSupply(ResultSet rs) throws SQLException {
        Supply supply = new Supply();
        supply.setId(rs.getInt(1));
        supply.setGoods_name(rs.getString(2));
        supply.setBusiness_id(rs.getInt(3));
        supply.setPrice(rs.getFloat(4));
        supply.setAmount(rs.getInt(5));
        supply.setCrate_time(rs.getTimestamp(6));
        supply.setImage_url(rs.getString(7));
        supply.setIntroduce(rs.getString(8));
        supply.setType(rs.getString(9));
        return supply;
    }
}
