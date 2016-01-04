/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 *
 * 数据传输类型 —— UserDTO
 *
 * @author Xinux
 * @version $Id: UserDTO.java, v 0.1 2015-12-29 11:37 AM Xinux Exp $$
 */
public class UserDTO extends BaseDTO {

    private static final long serialVersionUID = -3653684082548328746L;

    /**
     * 用户登陆号
     */
    @NotNull
    @Length(min = 1, max = 40)
    private String name;

    /**
     * 用户密码
     */
    @NotEmpty
    @Length(min = 1, max = 256)
    private String password;

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
     * Getter method for property password.
     *
     * @return property value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property password.
     *
     * @param password value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}