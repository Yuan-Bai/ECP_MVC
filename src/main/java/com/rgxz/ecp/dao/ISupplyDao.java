package com.rgxz.ecp.dao;

import com.rgxz.ecp.entity.Goods;
import com.rgxz.ecp.entity.Supply;

import java.util.ArrayList;

public interface ISupplyDao {
    boolean add(Supply supply);
    boolean delete(Supply supply);
    boolean update(Supply supply);
    ArrayList<String> findType();
    Supply findGoods(Integer id);
    Supply findGoods();
    ArrayList<Supply> findGoods(String goods_name);
}
