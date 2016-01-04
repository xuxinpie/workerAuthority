/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.exception;

/**
 *
 * 异常类 —— 密码不合法
 *
 * @author Xinux
 * @version $Id: InvalidPasswordException.java, v 0.1 2015-12-31 3:58 PM Xinux Exp $$
 */
public class InvalidPasswordException extends ServiceException {

    public InvalidPasswordException(String msg) {
        super(msg);
    }

    public InvalidPasswordException() {
        super("invalid password");
    }
}