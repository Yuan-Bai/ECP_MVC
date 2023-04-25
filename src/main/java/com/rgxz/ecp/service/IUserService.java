package com.rgxz.ecp.service;

import com.rgxz.ecp.common.Result;
import com.rgxz.ecp.entity.Business;
import com.rgxz.ecp.entity.User;
import java.util.Map;

public interface IUserService {
    int deleteByIds(Long[] ids);
    int addUser(User user);
    User findByUsername(User user);
    User findUserById(String userId);
    Result<String> register(String name, String pwd, String ip);
    Result<User> login(String name, String pwd, String ip);
    Result<Business> becomeBusiness(String user_name, String user_pwd, String business_name, String business_address, String business_phone, String image_url);

}
