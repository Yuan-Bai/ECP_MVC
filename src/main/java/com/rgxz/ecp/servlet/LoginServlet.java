package com.rgxz.ecp.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.rgxz.ecp.service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String userName = parameterMap.get("name")[0];
        String userPwd = parameterMap.get("pwd")[0];
        UserServiceImpl userService = new UserServiceImpl();
        JSONObject jsonObject = userService.login(userName, userPwd);
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.print(jsonObject.toJSONString());
    }
}
