package com.rgxz.ecp.service.impl;
import com.rgxz.ecp.common.CodeMsg;
import com.rgxz.ecp.common.Result;
import com.rgxz.ecp.dao.Impl.BusinessDaoImpl;
import com.rgxz.ecp.dao.Impl.UserDaoImpl;
import com.rgxz.ecp.entity.Business;
import com.rgxz.ecp.entity.User;
import com.rgxz.ecp.service.IUserService;


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
    public Result<String> register(String name, String pwd, String ip) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User(name, pwd, ip);
        if (userDao.add(user))
            return Result.success();
        else
            return Result.error(CodeMsg.REGISTER_USER_ERROR);
    }

    @Override
    public Result<User> login(String name, String pwd, String ip) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findUser(name);
        if (user == null || !user.getPwd().equals(pwd)) return Result.error(CodeMsg.USER_OR_PASS_ERROR);
        BusinessServiceImpl businessService = new BusinessServiceImpl();
        user.setBusiness(businessService.getBusiness(user.getId()).getData());
        return Result.success(user);
    }

    @Override
    public Result<Business> becomeBusiness(String user_name, String user_pwd, String business_name, String business_address, String business_phone, String image_url) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findUser(user_name);
        if (user.getPwd().equals(user_pwd)){
            Integer user_id = userDao.findId(user_name);
            BusinessDaoImpl businessDao = new BusinessDaoImpl();
            Business business = new Business(user_id, business_name, business_address, business_phone, image_url);
            // 如果注册商家失败返回注册商家失败的错误信息
            if (!businessDao.add(business)) return Result.error(CodeMsg.BECOME_BUSINESS_ERROR);
            if (!userDao.updateIsBusiness(user.getId(), true)) return Result.error(CodeMsg.SERVER_EXCEPTION);
            return Result.success(businessDao.findByUserId(user_id));
        }
        return Result.error(CodeMsg.USER_OR_PASS_ERROR);
    }
}
