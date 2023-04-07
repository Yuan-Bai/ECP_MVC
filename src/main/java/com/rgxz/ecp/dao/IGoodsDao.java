package com.rgxz.ecp.dao;

import com.rgxz.ecp.entity.Goods;

public interface IGoodsDao {
    boolean add(Goods goods);
    boolean delete(Goods goods);
    boolean update(Goods goods);
    Goods find(String userAccount, String pwd);
}
