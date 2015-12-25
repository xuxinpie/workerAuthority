/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.utils;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * 记录用户到Session
 *
 * @author Xinux
 * @version $Id: SessionUser.java, v 0.1 2015-12-24 6:57 PM Xinux Exp $$
 */
public class SessionUser implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 574540370604225553L;

    /**
     * 用户唯一标识
     */
    private String uid;

    /**
     * 登陆名
     */
    private String loginName;

    /**
     * 是否记住该用户
     */
    private String isRemember;

    /**
     * 登陆时间
     */
    private Date gmtLogin;

    /**
     * Getter method for property uid.
     *
     * @return property value of uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * Setter method for property uid.
     *
     * @param uid value to be assigned to property uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * Getter method for property loginName.
     *
     * @return property value of loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * Setter method for property loginName.
     *
     * @param loginName value to be assigned to property loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * Getter method for property isRemember.
     *
     * @return property value of isRemember
     */
    public String getIsRemember() {
        return isRemember;
    }

    /**
     * Setter method for property isRemember.
     *
     * @param isRemember value to be assigned to property isRemember
     */
    public void setIsRemember(String isRemember) {
        this.isRemember = isRemember;
    }

    /**
     * Getter method for property gmtLogin.
     *
     * @return property value of gmtLogin
     */
    public Date getGmtLogin() {
        return gmtLogin;
    }

    /**
     * Setter method for property gmtLogin.
     *
     * @param gmtLogin value to be assigned to property gmtLogin
     */
    public void setGmtLogin(Date gmtLogin) {
        this.gmtLogin = gmtLogin;
    }
}