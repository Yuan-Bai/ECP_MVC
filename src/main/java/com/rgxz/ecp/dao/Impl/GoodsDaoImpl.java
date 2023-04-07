package com.rgxz.ecp.dao.Impl;

import com.rgxz.ecp.dao.IGoodsDao;
import com.rgxz.ecp.entity.Goods;

public class GoodsDaoImpl implements IGoodsDao {
    @Override
    public boolean add(Goods goods) {
        String sqlFind = "select goodsname from adminsave.admins";
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
    public Goods find(String userAccount, String pwd) {
        return null;
    }
}
