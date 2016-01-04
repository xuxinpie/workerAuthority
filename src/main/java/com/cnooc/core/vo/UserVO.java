/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.vo;

import java.io.Serializable;

/**
 * @author Xinux
 * @version $Id: UserVO.java, v 0.1 2015-12-29 4:33 PM Xinux Exp $$
 */
public class UserVO implements Serializable {

    private static final long serialVersionUID = 2161436876527753443L;

    /**
     * 用户Id
     */
    private String uid;

    /**
     * 用户名
     */
    private String name;

    /**
     * 权限
     */
    private String privilege;

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
     * Getter method for property name.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property name.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property privilege.
     *
     * @return property value of privilege
     */
    public String getPrivilege() {
        return privilege;
    }

    /**
     * Setter method for property privilege.
     *
     * @param privilege value to be assigned to property privilege
     */
    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
}