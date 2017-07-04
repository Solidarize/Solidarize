package com.solidarize.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.hateoas.Resource;

import com.solidarize.model.Event;
import com.solidarize.model.Institution;
import com.solidarize.model.User;
import com.solidarize.service.EventService;
import com.solidarize.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class EventRestControllerTest {

    @Mock
    private EventService eventService;
    
    private EventRestController restController;

    @Before
    public void setUp() throws Exception {
        restController = new EventRestController(eventService);
    }

    @Test
    public void shouldBeAbeToGetEventById() throws Exception {
        int id = 1;
        
        Institution owner = new Institution("oi", "123456", "asdasds", "aaaaa", "aaaaaa");
        Event event = new Event("name", owner, 3, LocalDate.now(), "title", "subTitle", "address", LocalDate.now(), "description");
        when(eventService.getEventById(eq(id))).thenReturn(event);
        Event response = restController.getEventById(id);
        assertEquals(event, response);
    }

    @Test
    public void shouldBeAbeToGetEvents() throws Exception {
        String offset = "10";
        String order = "desc";
        Institution owner = new Institution("oi", "123456", "asdasds", "aaaaa", "aaaaaa");
        List<Event> event = Arrays.asList(new Event("name", owner, 3, LocalDate.now(), "title", "subTitle", "address", LocalDate.now(), "description"));
        when(eventService.getEvents(eq(offset),eq(order))).thenReturn(event);
        List<Event> response = restController.getEventsListByTimestamp(offset,order);
        assertEquals(event, response);
    }

    @Test
    public void shouldBeAbleToCreateEvent() throws Exception {
    	Institution owner = new Institution("oi", "123456", "asdasds", "aaaaa", "aaaaaa");
        Event event = new Event("name", owner, 4, LocalDate.now(), "title", "subTitle", "address", LocalDate.now(), "description");
        when(eventService.createEvent(eq(event))).thenReturn(event);
        Resource<Event> resource = restController.createEvent(event);
        assertEquals(event, resource.getContent());

    }

    @Test
    public void shouldBeAbleToUpdateEvent() throws Exception {
    	Institution owner = new Institution("oi", "123456", "asdasds", "aaaaa", "aaaaaa");
        Event event = new Event("name", owner, 4, LocalDate.now(), "title", "subTitle", "address", LocalDate.now(), "description");
        when(eventService.updateEvent(eq(event))).thenReturn(event);
        Resource<Event> resource = restController.updateEvent(event);
        assertEquals(event, resource.getContent());
    }

}