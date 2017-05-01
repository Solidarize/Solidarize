package com.solidarize.controller;

import org.springframework.social.facebook.api.Event;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/managementEvent")
public class EventManagementController {


    @GetMapping
    public ModelAndView buildManagementEventView(ModelAndView modelAndView) {
        modelAndView.setViewName("event/registryEvent");
        modelAndView.addObject(new Event());
        return modelAndView;
    }
}
