package com.rgxz.ecp.servlet;

import com.rgxz.ecp.common.Result;
import com.rgxz.ecp.service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import static com.rgxz.ecp.util.IpUtil.getIpAddress;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ip = getIpAddress(req);
        Map<String, String[]> parameterMap = req.getParameterMap();
        String userName = parameterMap.get("name")[0];
        String userPwd = parameterMap.get("pwd")[0];
        UserServiceImpl userService = new UserServiceImpl();
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        Result<String> result = userService.register(userName, userPwd, ip);
        // 注册后更新用户的信息
        out.print(result.toJSON().toJSONString());
    }
}
