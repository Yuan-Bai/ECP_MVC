package com.rgxz.ecp.servlet;

import com.rgxz.ecp.common.CodeMsg;
import com.rgxz.ecp.common.Result;
import com.rgxz.ecp.service.impl.BusinessServiceImpl;
import com.rgxz.ecp.util.ReceiveFile;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class UpLoadGoods extends HttpServlet {
    /**
     * @Author: YuanBai
     * @Date: 2023/4/23
     * @Param: [req, resp]
     * @Return: void
     * @Description: 处理上传商品请求
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        Map<String, String[]> parameterMap = req.getParameterMap();
        StringBuilder image_url = new StringBuilder("../webapps/ECP/image/goods_image/");
        String goods_name = parameterMap.get("goods_name")[0];
        String business_id = parameterMap.get("business_id")[0];
        String price = parameterMap.get("goods_price")[0];
        String amount = parameterMap.get("goods_amount")[0];
        String introduce = parameterMap.get("goods_introduce")[0];
        String type = parameterMap.get("goods_type")[0];
        BusinessServiceImpl  businessService = new BusinessServiceImpl();

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
            // 更新供应表，获取结果消息
            Result<String> result = businessService.upLoadGoods(goods_name, Integer.parseInt(business_id), Float.parseFloat(price),
                    Integer.parseInt(amount), image_url.toString(), introduce, type);
            // 将消息发送给客户端
            out.print(result.toJSON().toJSONString());
        } catch (IOException e) {
            log("响应输出异常");
        }
    }
}
