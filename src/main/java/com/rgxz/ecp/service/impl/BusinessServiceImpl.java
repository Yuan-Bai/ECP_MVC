package com.rgxz.ecp.service.impl;

import com.rgxz.ecp.common.CodeMsg;
import com.rgxz.ecp.common.Result;
import com.rgxz.ecp.dao.Impl.BusinessDaoImpl;
import com.rgxz.ecp.dao.Impl.SupplyDaoImpl;
import com.rgxz.ecp.entity.Business;
import com.rgxz.ecp.entity.Supply;
import com.rgxz.ecp.service.IBusinessService;

import java.util.Map;

public class BusinessServiceImpl implements IBusinessService {
    @Override
    public Result<Business> getBusiness(int user_id) {
        BusinessDaoImpl businessDao = new BusinessDaoImpl();
        Business business = businessDao.findByUserId(user_id);
        if (business==null) return Result.error(CodeMsg.NOT_FIND_DATA);
        return Result.success(business);
    }

    @Override
    public Result<String> upLoadGoods(String goods_name, int business_id, float price, int amount, String image_url,
                                      String introduce, String type) {
        Supply supply = new Supply(goods_name, business_id, price, amount, image_url, introduce, type);
        SupplyDaoImpl supplyDao = new SupplyDaoImpl();
        if (supplyDao.add(supply))
            return Result.success();
        else
            return Result.error(CodeMsg.UPLOAD_SUPPLY_ERROR);
    }
}
