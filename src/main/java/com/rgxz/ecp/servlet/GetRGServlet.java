package com.rgxz.ecp.servlet;

import com.rgxz.ecp.common.Result;
import com.rgxz.ecp.entity.Supply;
import com.rgxz.ecp.service.impl.SupplyServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;


public class GetRGServlet extends HttpServlet {
    /**
     * @Author: YuanBai
     * @Date: 2023/4/23
     * @Param: [req, resp]
     * @Return: void
     * @Description: 处理前端发起的获取随机商品请求
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String nums = parameterMap.get("nums")[0];
        SupplyServiceImpl service = new SupplyServiceImpl();
        Result<ArrayList<Supply>> result = service.getRandomGoodsList(Integer.parseInt(nums));
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.print(result.toJSON().toJSONString());
    }
}
