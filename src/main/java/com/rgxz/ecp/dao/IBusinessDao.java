package com.rgxz.ecp.dao;

import com.rgxz.ecp.entity.Business;

public interface IBusinessDao {
    boolean add(Business business);
    boolean delete(Business business);
    boolean update(Business business);
    Business findByName(String businessName);
    Business findByUserId(int user_id);
}
