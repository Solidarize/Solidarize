package com.solidarize.controller;

import com.solidarize.model.Event;
import com.solidarize.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/event")
public class EventRestController {

    private EventService eventService;

    @Autowired
    public EventRestController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(path = "/{id}", method = GET)
    public Event getEventById(@PathVariable("id") Integer id) {
        return eventService.getEventById(id);
    }

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    public Resource<Event> createEvent(@RequestBody Event event) {
        return new Resource<>(eventService.createEvent(event));
    }
}