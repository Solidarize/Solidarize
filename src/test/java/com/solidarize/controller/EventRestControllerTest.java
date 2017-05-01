package com.solidarize.controller;

import com.solidarize.model.Event;
import com.solidarize.service.EventService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.hateoas.Resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventRestControllerTest {

    @Mock
    private EventService service;

    private EventRestController restController;

    @Before
    public void setUp() throws Exception {
        restController = new EventRestController(service);
    }

    @Test
    public void shouldBeAbeToGetEventById() throws Exception {
        int id = 1;
        Event event = new Event("name", "owner",3);
        when(service.getEventById(eq(id))).thenReturn(event);
        Event response = restController.getEventById(id);
        assertEquals(event, response);
    }

    @Test
    public void shouldBeAbleToCreateEvent() throws Exception {
        Event event = new Event("name", "owner",4);
        when(service.createEvent(eq(event))).thenReturn(event);
        Resource<Event> resource = restController.createEvent(event);
        assertEquals(event, resource.getContent());

    }
}