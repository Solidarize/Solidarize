package com.solidarize.controller;

import com.solidarize.model.Event;
import com.solidarize.service.EventService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.hateoas.Resource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
        Event event = new Event("name", "owner", 3, LocalDate.now(), "title", "subTitle", "address", LocalDate.now(), "description");
        when(service.getEventById(eq(id))).thenReturn(event);
        Event response = restController.getEventById(id);
        assertEquals(event, response);
    }

    @Test
    public void shouldBeAbeToGetEvents() throws Exception {
        String offset = "10";
        String order = "desc";
        List<Event> event = Arrays.asList(new Event("name", "owner", 3, LocalDate.now(), "title", "subTitle", "address", LocalDate.now(), "description"));
        when(service.getEvents(eq(offset),eq(order))).thenReturn(event);
        List<Event> response = restController.getEventsById(offset,order);
        assertEquals(event, response);
    }

    @Test
    public void shouldBeAbleToCreateEvent() throws Exception {
        Event event = new Event("name", "owner", 4, LocalDate.now(), "title", "subTitle", "address", LocalDate.now(), "description");
        when(service.createEvent(eq(event))).thenReturn(event);
        Resource<Event> resource = restController.createEvent(event);
        assertEquals(event, resource.getContent());

    }

    @Test
    public void shouldBeAbleToUpdateEvent() throws Exception {
        Event event = new Event("name", "owner", 4, LocalDate.now(), "title", "subTitle", "address", LocalDate.now(), "description");
        when(service.updateEvent(eq(event))).thenReturn(event);
        Resource<Event> resource = restController.updateEvent(event);
        assertEquals(event, resource.getContent());
    }

}