/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.serviceImpl;

import com.cnooc.core.dao.UserDAO;
import com.cnooc.core.exception.ServiceException;
import com.cnooc.core.model.UserDO;
import com.cnooc.core.service.UserService;
import com.cnooc.core.utils.PwdEncoder;
import com.cnooc.core.vo.UserVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

//    @Autowired
//    private PwdEncoder pwdEncoder;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserVO doLogin(UserDO user) throws ServiceException {
        UserDO userDO = getUserByName(user.getName());
        if(userDO == null) {
            throw new ServiceException("error.account.not.exist");
        }
//        if(!pwdEncoder.isPasswordValid(userDO.getPassword(), user.getPassword())) {
//            throw new ServiceException("error.account.password.invalid");
//        }
        if(!StringUtils.equals(userDO.getPassword(), user.getPassword())) {
            throw new ServiceException("error.account.password.invalid");
        }
        return dataConverter(userDO);
    }

    /**
     * 数据转换器
     * User DO 2 VO converter
     *
     * @param userDO
     * @return
     */
    private UserVO dataConverter(UserDO userDO) {
        UserVO userVO = new UserVO();
        userVO.setName(userDO.getName());
        userVO.setUid(userDO.getUid());
        userVO.setPrivilege(userDO.getPrivilege());
        return userVO;
    }

    @Override
    public boolean addUser(UserDO user, String uid) throws ServiceException {
        return false;
    }

    @Override
    public List<UserDO> getAllUsers() {
        return userDAO.queryAllUsers();
    }

    @Override
    public UserDO getUserById(String uid) {
        return userDAO.queryUserByUid(uid);
    }

    @Override
    public UserDO getUserByName(String userName) {
        return userDAO.queryUserByName(userName);
    }


}