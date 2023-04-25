package com.rgxz.ecp.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReceiveFile {
    public void receiveParam(){

    }

    public static void receiveFile(HttpServletRequest req, StringBuilder businessImagePath) throws IOException {
        //设置缓冲区大小
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建一个上床据
        ServletFileUpload upload = new ServletFileUpload(factory);
        //设置上传文件大小
        upload.setFileSizeMax(1024*1024*50);
        upload.setSizeMax(1024*1024*50);
        //解决上传文件中文名称乱码
        upload.setHeaderEncoding("UTF-8");
        //定义一个List接受文件数据
        List<FileItem> iter = new ArrayList<>();
        //解析request对象，得到所有上传项，每一个fileItem相当于一个上传项（包括普通表单数据和文件数据）
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        // todo 判断上传数据是否是表单
        try {
            //遍历解析出来的对象
            assert items != null;
            iter.addAll(items);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果请求中存在文件
        //如果不存在文件那么iter.get(0).getName()
        if(!iter.get(0).getName().isEmpty()){
            //开始文件操作`
            //创建文件数据集合的迭代器
            //如果上传了多个文件，则会执行多次
            for (FileItem fileItem : iter) {
                //获取迭代器中数据（存储的是我们传上来的文件数据）
                //获取文件输入流
                InputStream input = fileItem.getInputStream();
                //获取文件名
                businessImagePath.append(fileItem.getName());
                try {
                    //新建文件
                    File file = new File(businessImagePath.toString());
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    OutputStream os = new FileOutputStream(file);
                    int read = 0;
                    byte[] bytes = new byte[1024 * 1024];
                    //先读后写
                    while ((read = input.read(bytes)) > 0) {
                        byte[] wBytes = new byte[read];
                        System.arraycopy(bytes, 0, wBytes, 0, read);
                        os.write(wBytes);
                    }
                    os.flush();
                    os.close();
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
