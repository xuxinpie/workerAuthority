/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.cnooc.core.interceptor;

import com.cnooc.common.logging.LogUtil;
import com.cnooc.common.logging.Logger;
import com.cnooc.common.logging.LoggerFactory;
import com.cnooc.core.enums.SessionKeyEnum;
import com.cnooc.core.utils.SessionUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *
 * 用户上下文拦截器
 *
 * @author Xinux
 * @version $Id: MemberContextInterceptor.java, v 0.1 2016-01-01 10:01 PM Xinux Exp $$
 */
public class MemberContextInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberContextInterceptor.class);

    private String loginUrl;

    private String returnUrl;

    private String[] excludeUrls;

    /**登录页面相关的常量*/
    //	public static final String PROCESS_URL = "processUrl";
    public static final String RETURN_URL = "returnUrl";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        //在用户超时退出的时候记录日志，以备跟踪和分析问题
        //		SessionTimeOutDto logInfo = new SessionTimeOutDto(cs==null?null:cs.getUserId(), sessionId, RequestUtils.getLocation(request));
        String uri = getURI(request);
        // 不在验证的范围内
        if (exclude(uri)) {
            return true;
        }

        //取出session中对应的用户信息
        SessionUser sessionUser = (SessionUser) request.getSession()
            .getAttribute(SessionKeyEnum.SESSION_USER.getCode());

        if (null != sessionUser) {
            request.setAttribute("sessionUser", sessionUser);
            return true;
        }

        if (isAjaxRequest(request)) {
            response.addHeader("sessionstate", "timeout");
            return false;
        }

        response.sendRedirect(getLoginUrl(request));
        return false;
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

    private String getLoginUrl(HttpServletRequest request) throws UnsupportedEncodingException {
        StringBuilder buff = new StringBuilder();
        if (loginUrl.startsWith("/")) {
            //使用获取绝对路径
            String ctx = request.getContextPath();
            if (!StringUtils.isBlank(ctx)) {
                buff.append(ctx);
            }
        }

        String returnUrl = request.getParameter(RETURN_URL);

        buff.append(loginUrl).append("?");
        if (returnUrl == null || "".equals(returnUrl)) {
            buff.append(RETURN_URL).append("=").append(encode(getLocation(request)));
        } else {
            buff.append(RETURN_URL).append("=").append(encode(returnUrl));
        }

        //		if (!StringUtils.isBlank(processUrl)) {
        //			buff.append("&").append(PROCESS_URL).append("=").append(
        //					getProcessUrl(request));
        //		}
        return buff.toString();
    }

    /**
     *
     * 使用utf-8进行url解码
     *
     * @param url
     * @return
     */
    public String encode(String url) {
        String str = url;
        if (StringUtils.isBlank(str)) {
            return str;
        }
        try {
            str = URLEncoder.encode(url, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 获得当的访问路径
     *
     * HttpServletRequest.getRequestURL+"?"+HttpServletRequest.getQueryString
     *
     * @param request
     * @return
     */
    public static String getLocation(HttpServletRequest request) {
        UrlPathHelper helper = new UrlPathHelper();
        StringBuffer buff = request.getRequestURL();
        String uri = request.getRequestURI();
        String origUri = helper.getOriginatingRequestUri(request);
        buff.replace(buff.length() - uri.length(), buff.length(), origUri);
        String queryString = helper.getOriginatingQueryString(request);
        if (queryString != null) {
            buff.append("?").append(queryString);
        }
        return buff.toString();
    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equalsIgnoreCase(requestType)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean exclude(String uri) {
        //System.out.println(JSON.toJSONString(excludeUrls));
        if (excludeUrls != null) {
            for (String exc : excludeUrls) {
                if (exc.equals(uri)) {
                    return true;
                } else
                    if (exc.endsWith("*") && uri.startsWith(exc.substring(0, exc.length() - 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获得第三个路径分隔符的位置
     *
     * @param request
     * @throws IllegalStateException
     *             访问路径错误，没有三(四)个'/'
     */
    private String getURI(HttpServletRequest request) throws IllegalStateException {
        UrlPathHelper helper = new UrlPathHelper();
        String uri = helper.getOriginatingRequestUri(request);
        String ctxPath = helper.getOriginatingContextPath(request);
        if (!StringUtils.isBlank(ctxPath)) {
            int start = uri.indexOf('/', 1);
            uri = uri.substring(start);
        }
        LogUtil.debug(LOGGER, "The URI is: {0}", uri);
        return uri;
    }

    /**
     * Setter method for property loginUrl.
     *
     * @param loginUrl value to be assigned to property loginUrl
     */
    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    /**
     * Setter method for property returnUrl.
     *
     * @param returnUrl value to be assigned to property returnUrl
     */
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    /**
     * Setter method for property excludeUrls.
     *
     * @param excludeUrls value to be assigned to property excludeUrls
     */
    public void setExcludeUrls(String[] excludeUrls) {
        this.excludeUrls = excludeUrls;
    }

}