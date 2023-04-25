package com.rgxz.ecp.service;

import com.rgxz.ecp.common.Result;
import com.rgxz.ecp.entity.Business;
import com.rgxz.ecp.entity.Supply;


public interface IBusinessService {
    Result<Business> getBusiness(int user_id);
    Result<String> upLoadGoods(String goods_name, int business_id, float price, int amount, String image_url,
                               String introduce, String type);
}
