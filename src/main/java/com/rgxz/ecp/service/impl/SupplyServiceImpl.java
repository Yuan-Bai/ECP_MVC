package com.rgxz.ecp.service.impl;

import com.rgxz.ecp.common.Result;
import com.rgxz.ecp.entity.Supply;
import com.rgxz.ecp.service.ISupplyService;
import com.rgxz.ecp.dao.Impl.SupplyDaoImpl;
import java.util.ArrayList;

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
    public Result<ArrayList<Supply>> findGoodsByName(String goods_name) {
        SupplyDaoImpl supplyDao = new SupplyDaoImpl();
        ArrayList<Supply> supplyArrayList = supplyDao.findGoods(goods_name);
        return Result.success(supplyArrayList);
    }

    @Override
    public Result<ArrayList<Supply>> getRandomGoodsList(int nums) {
        SupplyDaoImpl supplyDao = new SupplyDaoImpl();
        ArrayList<Supply> supplyArrayList = new ArrayList<>();
        for (int i=0;i<24;i++){
            supplyArrayList.add(supplyDao.findGoods());
        }
        return Result.success(supplyArrayList);
    }
}
