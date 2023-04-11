package com.rgxz.ecp.dao;
import com.rgxz.ecp.entity.User;

public interface IUserDao {
    boolean add(User user);
    boolean delete(User user);
    boolean update(User user);
    User findUser(String name);
    boolean updateBusinessId(int business_id, String user_name);
}
