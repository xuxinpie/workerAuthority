/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.exception;

/**
 *
 * 服务异常类
 *
 * @author Xinux
 * @version $Id: ServiceException.java, v 0.1 2015-12-24 7:14 PM Xinux Exp $$
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = 3062973533895591317L;

    public ServiceException(){
        super();
    }

    public ServiceException(String msg){
        super(msg);
    }

    public ServiceException(String msg, Throwable cause){
        super(msg, cause);
    }

}