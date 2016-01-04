/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.exception;

/**
 *
 * 异常类——无法根据条件找到对应用户
 *
 * @author Xinux
 * @version $Id: UserNotFoundException.java, v 0.1 2015-12-31 3:57 PM Xinux Exp $$
 */
public class UserNotFoundException extends ServiceException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}