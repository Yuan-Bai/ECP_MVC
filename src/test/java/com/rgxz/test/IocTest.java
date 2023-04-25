package com.rgxz.test;

import com.rgxz.ecp.common.Result;
import com.rgxz.ecp.dao.Impl.GoodsDaoImpl;
import com.rgxz.ecp.dao.Impl.UserDaoImpl;
import com.rgxz.ecp.entity.Goods;
import com.rgxz.ecp.entity.User;
import org.junit.Test;

import java.sql.Date;
import java.util.Map;


public class IocTest {
    @Test
    public void test01(){
//        User user = new User("2020117163", "123456879", "12312");
//        Result<User> result = Result.success(user);
//        System.out.println(result.toJSON().toJSONString());
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
