/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.dao;

import com.cnooc.core.model.UserDO;

import java.util.List;

/**
 * @author Xinux
 * @version $Id: UserDAO.java, v 0.1 2015-12-24 8:23 PM Xinux Exp $$
 */
public interface UserDAO {

    public int insertUser(UserDO user);

    public UserDO queryUserByUid(String uid);

    public int updatePassword(String uid, String password);

    public List<UserDO> queryAllUsers();

    public UserDO queryUserByName(String userName);

    
}