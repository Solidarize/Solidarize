package com.solidarize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class EventController {

    public static final String LIST_EVENT_URL = "/listEvent";

    @RequestMapping(value = "/detailEvent", method = GET)
    public ModelAndView createDetailEventPage(ModelAndView modelAndView) {
        modelAndView.setViewName("event/detailEvent");
        return modelAndView;
    }

    @RequestMapping(value = LIST_EVENT_URL, method = GET)
    public ModelAndView createListEventPage(ModelAndView modelAndView) {
        modelAndView.setViewName("event/listEvent");
        return modelAndView;
    }

    @RequestMapping(value = "/index", method = GET)
    public ModelAndView getIndex(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = GET)
    public ModelAndView redirectToIndex(ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:index");
        return modelAndView;
    }


    @RequestMapping(value = "/sobre", method = GET)
    public ModelAndView getSobre(ModelAndView modelAndView) {
        modelAndView.setViewName("sobre");
        return modelAndView;
    }
}
