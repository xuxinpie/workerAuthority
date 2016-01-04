/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.cnooc.core.controller;

import com.cnooc.core.model.UserDO;
import com.cnooc.core.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Xinux
 * @version $Id: UserController.java, v 0.1 2015-12-24 10:19 PM Xinux Exp $$
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/showUser")
    public ModelAndView showUser(HttpServletRequest request) {
        String userId = request.getParameter("uid");
        UserDO user = userService.getUserById(userId);
        return new ModelAndView("showUser", "user", user);
    }

    @RequestMapping(value = "/list", method= RequestMethod.GET)
    public ModelAndView showAllUsers() {
        List<UserDO> users = userService.getAllUsers();
        for (UserDO user : users) {
            System.out.println(user);
        }

        return new ModelAndView("listUsers", "users", users);
    }
}