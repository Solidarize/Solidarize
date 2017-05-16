package com.solidarize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class EventController {

    @RequestMapping(value = "/detailEvent", method = GET)
    public ModelAndView createDetailEventPage(ModelAndView modelAndView){
        modelAndView.setViewName("event/detailEvent");
        return modelAndView;
    }

    @RequestMapping(value = "/listEvent", method = GET)
    public ModelAndView createListEventPage(ModelAndView modelAndView){
        modelAndView.setViewName("event/listEvent");
        return modelAndView;
    }
}
