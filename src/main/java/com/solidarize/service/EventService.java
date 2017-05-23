package com.solidarize.service;

import com.solidarize.model.Event;
import com.solidarize.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;

import static com.solidarize.service.EventService.OrderBy.ASC;
import static com.solidarize.service.EventService.OrderBy.DESC;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event getEventById(Integer id) {
        return eventRepository.findEventById(id);
    }

    public List<Event> getEvents(String offset, String order) {
        Pageable pageable = new PageRequest(0, Integer.parseInt(offset));
        if (order.toUpperCase().equals(DESC.name())) {
            return eventRepository.findAllByOrderByTimestampDesc(pageable);
        } else if (order.toUpperCase().equals(ASC.name())) {
            return eventRepository.findAllByOrderByTimestampAsc(pageable);
        }
        throw new BadRequestException();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }


    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }


    public void deleteEvent(Integer id) {
        eventRepository.delete(id);
    }

    public List<Event> getEventsByRank(String offset, String order) {
        Pageable pageable = new PageRequest(0, Integer.parseInt(offset));
        if (order.toUpperCase().equals(DESC.name())) {
            return eventRepository.findAllByOrderByRankDesc(pageable);
        } else if (order.toUpperCase().equals(ASC.name())) {
            return eventRepository.findAllByOrderByRankAsc(pageable);
        }
        throw new BadRequestException();
    }

    enum OrderBy {
        DESC,
        ASC
    }
}