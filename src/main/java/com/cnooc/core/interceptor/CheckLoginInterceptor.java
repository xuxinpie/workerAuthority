/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.cnooc.core.interceptor;

import com.cnooc.core.enums.SessionKeyEnum;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 登录检测拦截器，根据session中是否有User，避免重复登录
 *
 * @author Xinux
 * @version $Id: CheckLoginInterceptor.java, v 0.1 2016-01-04 10:54 AM Xinux Exp $$
 */
public class CheckLoginInterceptor implements HandlerInterceptor {

    /**
     *
     * 登陆拦截器前置处理,如果session中存在user对象,则直接跳转到主页
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (null == httpServletRequest.getSession()
            .getAttribute(SessionKeyEnum.SESSION_USER.getCode())) {
            return true;
        } else {
            httpServletResponse.sendRedirect("main");
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o,
                                Exception e) throws Exception {

    }
}