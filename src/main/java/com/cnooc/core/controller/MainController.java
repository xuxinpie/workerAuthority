/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.cnooc.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Main Page Controller
 *
 * @author Xinux
 * @version $Id: MainController.java, v 0.1 2016-01-01 10:28 PM Xinux Exp $$
 */
@Controller
@RequestMapping(value = "/main")
public class MainController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String main(HttpServletRequest request, ModelMap modelMap) {
        modelMap.put("user", getSessionUser(request));
        return "main";
    }

}