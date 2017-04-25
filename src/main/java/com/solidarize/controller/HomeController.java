package com.solidarize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping
    public ModelAndView buildHomePage(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        modelAndView.getModelMap().put("name", "Solidarize");
        return modelAndView;
    }

}
