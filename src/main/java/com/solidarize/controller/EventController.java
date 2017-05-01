package com.solidarize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

    @RequestMapping(value = "/detailEvent")
    public ModelAndView createDetailEventPage(ModelAndView modelAndView){
        modelAndView.setViewName("event/detailEvent");
        return modelAndView;
    }

    @RequestMapping(value = "/listEvent")
    public ModelAndView createListEventPage(ModelAndView modelAndView){
        modelAndView.setViewName("event/listEvent");
        return modelAndView;
    }
}
