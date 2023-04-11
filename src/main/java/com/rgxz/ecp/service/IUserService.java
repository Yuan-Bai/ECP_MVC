package com.rgxz.ecp.service;

import com.alibaba.fastjson2.JSONObject;
import com.rgxz.ecp.entity.User;

public interface IUserService {
    int deleteByIds(Long[] ids);
    int addUser(User user);
    User findByUsername(User user);
    User findUserById(String userId);
    Boolean register(String name, String pwd);
    JSONObject login(String name, String pwd);
    Boolean becomeBusiness(String name, String pwd);
}
