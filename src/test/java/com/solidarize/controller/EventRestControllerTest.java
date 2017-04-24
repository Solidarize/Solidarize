package com.solidarize.controller;

import com.solidarize.model.Event;
import com.solidarize.model.Institution;
import com.solidarize.service.EventService;
import java.util.Date;
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
        Institution institution = new Institution("nome","descricao");
        Event event = new Event("nome", "descricao", 0, new Date(), institution);
        when(service.getEventById(eq(id))).thenReturn(event);
        Event response = restController.getEventById(id);
        assertEquals(event, response);
    }

    @Test
    public void shouldBeAbleToCreateEvent() throws Exception {
        Institution institution = new Institution("nome","descricao");
        Event event = new Event("nome", "descricao", 0, new Date(), institution);
        when(service.createEvent(eq(event))).thenReturn(event);
        Resource<Event> resource = restController.createEvent(event);
        assertEquals(event, resource.getContent());

    }
}