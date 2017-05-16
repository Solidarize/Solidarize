package com.solidarize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class InstututionController {

    @RequestMapping(value = "/detailInstitution", method = GET)
    public ModelAndView createDetailEventPage(ModelAndView modelAndView){
        modelAndView.setViewName("institution/detailEvent");
        return modelAndView;
    }

    @RequestMapping(value = "/listInstitutions", method = GET)
    public ModelAndView createListEventPage(ModelAndView modelAndView){
        modelAndView.setViewName("institution/listInstitutions");
        return modelAndView;
    }
	
}
