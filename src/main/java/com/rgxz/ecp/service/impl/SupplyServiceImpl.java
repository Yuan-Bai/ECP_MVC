package com.rgxz.ecp.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.rgxz.ecp.entity.Supply;
import com.rgxz.ecp.service.ISupplyService;
import com.rgxz.ecp.dao.Impl.SupplyDaoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SupplyServiceImpl implements ISupplyService {
    @Override
    public boolean addGoods(String goods_name, Integer business_id, Float price, Integer amount, String image_url, String introduce, String type) {
        Supply supply = new Supply(goods_name, business_id, price, amount, image_url, introduce, type);
        SupplyDaoImpl supplyDao = new SupplyDaoImpl();
        return supplyDao.add(supply);
    }

    @Override
    public Supply findGoods(Integer id) {
        return null;
    }

    @Override
    public JSONObject findGoods(String goods_name) {
        SupplyDaoImpl supplyDao = new SupplyDaoImpl();
        ArrayList<Supply> supplyArrayList = supplyDao.findGoods(goods_name);
        Map<String, Supply> map = new HashMap<>();
        for (int i = 0; i < supplyArrayList.size(); i++) {
            map.put(String.valueOf(i), supplyArrayList.get(i));
        }
        return new JSONObject(map);
    }

    @Override
    public JSONObject findRandomGoods() {
        SupplyDaoImpl supplyDao = new SupplyDaoImpl();
        Map<String, Supply> map = new HashMap<>();
        for (int i=0;i<24;i++){
            map.put(String.valueOf(i), supplyDao.findGoods());
        }
        return new JSONObject(map);
    }
}
