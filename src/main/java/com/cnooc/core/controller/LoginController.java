/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.controller;

import com.cnooc.core.dto.UserDTO;
import com.cnooc.core.enums.SessionKeyEnum;
import com.cnooc.core.exception.ServiceException;
import com.cnooc.core.model.UserDO;
import com.cnooc.core.service.UserService;
import com.cnooc.core.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 登陆功能控制器
 *
 * @author Xinux
 * @version $Id: LoginController.java, v 0.1 2015-12-24 7:16 PM Xinux Exp $$
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(method= RequestMethod.GET)
    public String login(HttpServletRequest request) {

        return "login";
    }

    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView postLogin(HttpServletRequest request, HttpServletResponse response,
                                  ModelMap modelMap, UserDTO userDTO) throws IOException{
        try {

            UserVO userVO = userService.doLogin(converter(userDTO));
            setSessionUser(request, initSessionUser(userVO));
            modelMap.put("user", userVO);
            return new ModelAndView("main");
        } catch (ServiceException e) {
            sendError(request, response, e.getMessage());
        }
        return new ModelAndView("login");
    }

    /**
     * 用户数据转换器
     * 表格提交UserDTO 转为 UserDO
     * @param userDTO
     * @return
     */
    private UserDO converter(UserDTO userDTO) {

        UserDO userDO = new UserDO();
        userDO.setName(userDTO.getName());
        userDO.setPassword(userDTO.getPassword());
        return userDO;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, RedirectAttributes redirectAttr) {
        removeSession(request, SessionKeyEnum.SESSION_USER.getCode());
        return "login";
    }

}