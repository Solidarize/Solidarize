package com.solidarize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InstututionController {

    @RequestMapping(value = "/detailInstitution")
    public ModelAndView createDetailEventPage(ModelAndView modelAndView){
        modelAndView.setViewName("institution/detailEvent");
        return modelAndView;
    }

    @RequestMapping(value = "/listInstitutions")
    public ModelAndView createListEventPage(ModelAndView modelAndView){
        modelAndView.setViewName("institution/listInstitutions");
        return modelAndView;
    }
	
}
