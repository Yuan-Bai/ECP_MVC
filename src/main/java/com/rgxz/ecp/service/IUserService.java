package com.rgxz.ecp.service;

import com.rgxz.ecp.entity.User;

public interface IUserService {
    int deleteByIds(Long[] ids);
    int addUser(User user);
    User findByUsername(User user);
    User findUserById(String userId);
}
