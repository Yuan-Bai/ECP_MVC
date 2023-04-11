package com.rgxz.ecp.service.impl;
import com.alibaba.fastjson2.JSONObject;
import com.rgxz.ecp.dao.Impl.UserDaoImpl;
import com.rgxz.ecp.entity.User;
import com.rgxz.ecp.service.IUserService;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements IUserService {
    @Override
    public int deleteByIds(Long[] ids) {
        return 0;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public User findByUsername(User user) {
        return null;
    }

    @Override
    public User findUserById(String userId) {
        return null;
    }

    @Override
    public Boolean register(String name, String pwd) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User(name, pwd);
        return userDao.add(user);
    }

    @Override
    public JSONObject login(String name, String pwd) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findUser(name);
        Map<String, String> map = new HashMap<>();
        String isLogin = "fail";
        if (user.getPwd().equals(pwd))
            isLogin = "success";
        map.put("is_login", isLogin);
        map.put("user", user.toString());
//        map.put("id", user.getId().toString());
//        map.put("name", user.getName());
//        map.put("address", user.getAddress());
//        map.put("phone", user.getPhone());
//        map.put("balance", user.getBalance().toString());
//        map.put("gender", user.getGender());
//        map.put("image_url", user.getImage_url());
//        map.put("identity", user.getIdentity().toString());
//        map.put("business_id", user.getBusiness_id().toString());
//        map.put("create_time", user.getCreate_time().toString());
        return new JSONObject(map);
    }

    @Override
    public Boolean becomeBusiness(String name, String pwd) {
        return null;
    }
}
