package com.rgxz.ecp.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.rgxz.ecp.service.impl.SupplyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetRGServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SupplyServiceImpl service = new SupplyServiceImpl();
        JSONObject jsonObject = service.findRandomGoods();
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonObject.toJSONString());
    }
}
