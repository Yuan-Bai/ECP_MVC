package com.rgxz.ecp.service.impl;

import com.rgxz.ecp.dao.Impl.GoodsDaoImpl;
import com.rgxz.ecp.entity.Goods;
import com.rgxz.ecp.service.IGoodsService;

public class GoodsServiceImpl implements IGoodsService {
    @Override
    public boolean addGoods(Goods goods) {
        GoodsDaoImpl goodsDao = new GoodsDaoImpl();
        return goodsDao.add(goods);
    }
}
