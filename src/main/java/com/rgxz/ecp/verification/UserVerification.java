package com.rgxz.ecp.verification;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserVerification extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] user_id = req.getParameterValues("UserID");
        String[] user_pwd = req.getParameterValues("UserPWD");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        if (user_id[0].equals("2020117163")&&user_pwd[0].equals("123456")){
            out.print("登录成功");
        }
        else {
            out.print("登录失败");
        }
    }
}
