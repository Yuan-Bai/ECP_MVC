package com.rgxz.ecp.servlet;

import com.rgxz.ecp.common.CodeMsg;
import com.rgxz.ecp.common.Result;
import com.rgxz.ecp.entity.Business;
import com.rgxz.ecp.service.impl.UserServiceImpl;
import com.rgxz.ecp.util.ReceiveFile;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

public class BecomeBusiness extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        Map<String, String[]> parameterMap = req.getParameterMap();
        String userName = parameterMap.get("user_name")[0];
        String userPwd = parameterMap.get("user_pwd")[0];
        String businessName = parameterMap.get("business_name")[0];
        String businessAddress = parameterMap.get("business_address")[0];
        String businessPhone = parameterMap.get("business_phone")[0];
        StringBuilder image_url = new StringBuilder("../webapps/ECP/image/business_head_image/");

        resp.setCharacterEncoding("utf-8");
        try (PrintWriter out = resp.getWriter()) {
            // 保存商品图片，处理异常，发生异常返回
            try {
                ReceiveFile.receiveFile(req, image_url);
            } catch (IOException e) {
                log("保存图片异常");
                out.print(Result.error(CodeMsg.UPLOAD_IMAGE_ERROR).toJSON().toJSONString());
                return;
            }
            UserServiceImpl userService = new UserServiceImpl();
            Result<Business> result = userService.becomeBusiness(userName, userPwd, businessName, businessAddress, businessPhone, image_url.toString());
            out.print(result.toJSON().toJSONString());
        } catch (IOException e) {
            log("响应输出异常");
        }
    }
}
