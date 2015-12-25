/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.service;

import com.cnooc.core.exception.ServiceException;
import com.cnooc.core.model.User;

import java.util.List;

/**
 * @author Xinux
 * @version $Id: UserService.java, v 0.1 2015-12-24 7:12 PM Xinux Exp $$
 */
public interface UserService {

    /**
     *
     * 用户登陆
     *
     * @param user
     * @return
     * @throws ServiceException
     */
    public User doLogin(User user) throws ServiceException;

    /**
     *
     * 添加一个用户
     *
     * @param user
     * @param uid
     * @return
     * @throws ServiceException
     */
    public boolean addUser(User user, String uid) throws ServiceException;

    /**
     * 列出所有用户
     *
     * @return
     */
    public List<User> getAllUsers();

    /**
     * 根据用户id查找用户
     *
     * @param uid
     * @return User
     */
    public User getUserById(String uid);


}