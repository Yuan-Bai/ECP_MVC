package com.rgxz.ecp.servlet;

import com.rgxz.ecp.service.impl.SupplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AddProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        //String goods_name, Integer business_id, Float price, Integer amount, String image_url, String introduce, String type
//        String goods_name = parameterMap.get("goods_name")[0];
//        Integer business_id = (Integer)parameterMap.get("business_id")[0];
//        String price = parameterMap.get("price")[0];
//        String amount = parameterMap.get("amount")[0];
//        String image_url = parameterMap.get("image_url")[0];
//        String introduce = parameterMap.get("introduce")[0];
//        String type = parameterMap.get("type")[0];
//        SupplyServiceImpl service = new SupplyServiceImpl();
//        service.addGoods("")
    }
}
