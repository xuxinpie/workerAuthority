/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.serviceImpl;

import com.cnooc.core.dao.UserDAO;
import com.cnooc.core.exception.ServiceException;
import com.cnooc.core.model.User;
import com.cnooc.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 用户服务接口实现类
 *
 * @author Xinux
 * @version $Id: UserServiceImpl.java, v 0.1 2015-12-24 7:20 PM Xinux Exp $$
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User doLogin(User user) throws ServiceException {
        return null;
    }

    @Override
    public boolean addUser(User user, String uid) throws ServiceException {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.queryAllUsers();
    }

    @Override
    public User getUserById(String uid) {
        return userDAO.queryUserByUid(uid);
    }


}