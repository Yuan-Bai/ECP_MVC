package com.rgxz.ecp.servlet;

import com.rgxz.ecp.entity.User;
import com.rgxz.ecp.service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String userName = parameterMap.get("name")[0];
        String userPwd = parameterMap.get("pwd")[0];
        UserServiceImpl userService = new UserServiceImpl();
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        if (userService.register(userName, userPwd))
            out.print("success");
        else
            out.print("error");
    }
}
