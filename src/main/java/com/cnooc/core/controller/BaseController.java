/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.controller;

import com.cnooc.core.model.User;
import com.cnooc.core.utils.SessionUser;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 *
 * Controller 基类
 *
 * @author Xinux
 * @version $Id: BaseController.java, v 0.1 2015-12-24 6:56 PM Xinux Exp $$
 */
public class BaseController {

    @Resource
    public MessageSource messageSource;

    public final static String SESSION_KEY = "sessionuserkey";

    public Map<String, Object> ajaxResult(Boolean success, Object arg) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", success);
        map.put("data", arg);
        return map;
    }

    /**
     * 初始化sessionUser
     *
     * @param user
     * @return
     */
    public SessionUser initSessionUser(User user) {

        if (user == null) {
            return null;
        }
        SessionUser sessionUser = new SessionUser();
        sessionUser.setLoginName(user.getName());
        sessionUser.setUid(user.getUid());
        sessionUser.setGmtLogin(new Date());

        return sessionUser;
    }


    /**
     * 获取当前登录用户uid
     *
     * @param request
     * @return
     */
    public String getUid(HttpServletRequest request) {
        return getSessionUser(request).getUid();
    }

    /**
     *
     * @param request
     * @return
     */
    public SessionUser getSessionUser(HttpServletRequest request) {
        return (SessionUser) request.getSession().getAttribute(SESSION_KEY);
    }

    /**
     *
     * 设置session中的User
     *
     * @param request
     * @param sessionUser
     */
    public void setSessionUser(HttpServletRequest request, SessionUser sessionUser) {
        request.getSession().setAttribute(SESSION_KEY, sessionUser);
    }

    /**
     *
     * 移除session
     *
     * @param request
     * @param sessionKey
     */
    public void removeSession(HttpServletRequest request, String sessionKey) {
        request.getSession().removeAttribute(sessionKey);
    }

    /**
     * 发送错误
     * @param request
     * @param response
     * @param errorCode
     * @throws IOException
     */
    protected void sendError(HttpServletRequest request, HttpServletResponse response, String errorCode) throws IOException {
        String msg = messageSource.getMessage(errorCode, null, getLocale(request));

        response.addHeader("parox_error", URLEncoder.encode(msg, "utf-8"));

        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, errorCode);
    }

    /**
     * 国际化
     *
     * @param request
     * @return
     */
    private Locale getLocale(HttpServletRequest request) {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if (localeResolver != null) {
            return localeResolver.resolveLocale(request);
        }
        return null;
    }

}