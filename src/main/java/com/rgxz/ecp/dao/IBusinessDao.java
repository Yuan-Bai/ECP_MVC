package com.rgxz.ecp.dao;

import com.rgxz.ecp.entity.Business;

public interface IBusinessDao {
    boolean add(Business business);
    boolean delete(Business business);
    boolean update(Business business);
    Business find(String businessName);
}
