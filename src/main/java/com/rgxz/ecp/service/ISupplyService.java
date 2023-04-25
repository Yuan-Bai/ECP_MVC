package com.rgxz.ecp.service;

import com.alibaba.fastjson2.JSONObject;
import com.rgxz.ecp.common.Result;
import com.rgxz.ecp.entity.Supply;

import java.util.ArrayList;
import java.util.Map;

public interface ISupplyService {
    boolean addGoods(String goods_name, Integer business_id, Float price, Integer amount, String image_url, String introduce, String type);
    Supply findGoods(Integer id);
    Result<ArrayList<Supply>> findGoodsByName(String goods_name);
    Result<ArrayList<Supply>> getRandomGoodsList(int nums);
}
