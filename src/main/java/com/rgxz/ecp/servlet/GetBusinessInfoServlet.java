package com.rgxz.ecp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: YuanBai
 * @Date: 2023-04-25
 * @Description: 获取自身商家信息
 * @Version: 1.0.0
 */

public class GetBusinessInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String userName = parameterMap.get("name")[0];
        String userPwd = parameterMap.get("pwd")[0];
    }
}
