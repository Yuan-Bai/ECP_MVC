package com.rgxz.test;

import com.rgxz.ecp.dao.Impl.GoodsDaoImpl;
import com.rgxz.ecp.dao.Impl.UserDaoImpl;
import com.rgxz.ecp.entity.Goods;
import com.rgxz.ecp.entity.User;
import org.junit.Test;

import java.sql.Date;


public class IocTest {
    @Test
    public void test01(){
        GoodsDaoImpl goodsDao = new GoodsDaoImpl();
        Date date = new Date(new java.util.Date().getTime());
        Goods goods = new Goods("redmi k50u", "小米京东自营旗舰店", "手机", "骁龙8+旗舰处理器 12GB+256GB", date, "k50u.jpg", 100, 2599);
        System.out.println(goodsDao.add(goods));
    }

    @Test
    public void test02(){
        UserDaoImpl userDao = new UserDaoImpl();
//        User user = new User(null, "2020117163", "87654321", "mmm", 2000.0F, 0);
//        System.out.println(userDao.add(user));
    }

    @Test
    public void test03(){
        UserDaoImpl userDao = new UserDaoImpl();
//        System.out.println(userDao.find("2020117163"));
    }
}
