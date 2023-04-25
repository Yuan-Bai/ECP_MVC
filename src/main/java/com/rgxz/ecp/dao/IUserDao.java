package com.rgxz.ecp.dao;
import com.rgxz.ecp.entity.User;

public interface IUserDao {
    boolean add(User user);
    boolean delete(User user);
    boolean updateIsBusiness(int id, Boolean is_business);
    User findUser(String name);
    String findPwd(String name);
    Integer findId(String name);
}
