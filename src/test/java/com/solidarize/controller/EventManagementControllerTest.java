package com.solidarize.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.assertEquals;

public class EventManagementControllerTest {


    private EventManagementController controller;

    @Before
    public void setUp() throws Exception {
        controller = new EventManagementController();
    }

    @Test
    public void shouldBeAbleToCreateViewForEventRegistry() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        ModelAndView response = controller.buildManagementEventView(modelAndView);
        assertEquals("event/registryEvent", response.getViewName());
    }
}