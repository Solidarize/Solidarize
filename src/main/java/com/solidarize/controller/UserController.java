package com.solidarize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class UserController {

    public static final String LIST_USER_URL = "/listUser";

    @RequestMapping(value = "/detailUser", method = GET)
    public ModelAndView createDetailUserPage(ModelAndView modelAndView) {
        modelAndView.setViewName("user/detailUser");
        return modelAndView;
    }

    @RequestMapping(value = LIST_USER_URL, method = GET)
    public ModelAndView createListUserPage(ModelAndView modelAndView) {
        modelAndView.setViewName("user/listUser");
        return modelAndView;
    }
}