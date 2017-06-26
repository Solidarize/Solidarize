package com.solidarize.service;

import com.solidarize.model.Event;
import com.solidarize.model.Institution;
import com.solidarize.repository.EventRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.BadRequestException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    @Mock
    private EventRepository repository;
    private EventService service;

    @Before
    public void setUp() throws Exception {
        service = new EventService(repository);
    }

    @Test
    public void shouldBeAbleToGetEvent() throws Exception {
        int id = 1;
        Institution owner = new Institution("oi", "123456", "asdasds", "aaaaa", "aaaaaa");
        Event event = new Event("name", owner, 2, LocalDate.now(), "title", "subTitle", "address", LocalDate.now(), "description");
        when(repository.findEventById(eq(id))).thenReturn(event);
        Event response = service.getEventById(id);
        assertEquals(event, response);
    }

    @Test
    public void shouldBeAbleToSaveAnEvent() throws Exception {
    	Institution owner = new Institution("oi", "123456", "asdasds", "aaaaa", "aaaaaa");
        Event event = new Event("name", owner, 2, LocalDate.now(), "title", "subTitle", "address", LocalDate.now(), "description");
        when(repository.save(eq(event))).thenReturn(event);
        Event response = service.createEvent(event);
        assertEquals(event, response);
    }

    @Test
    public void shouldBeAbleToDeletarAnEvent() throws Exception {
        int id = 1;
        service.deleteEvent(id);
        verify(repository).delete(eq(id));
    }

    @Test
    public void shouldBeAbleToRetrieveEventsOrderedByDESC() throws Exception {
        String offset = "10";
        String order = "desc";
        Institution owner = new Institution("oi", "123456", "asdasds", "aaaaa", "aaaaaa");
        List<Event> event = Arrays.asList(new Event("name", owner, 2, LocalDate.now(), "title", "subTitle", "address", LocalDate.now(), "description"));
        when(repository.findAllByOrderByTimestampDesc(any())).thenReturn(event);
        List<Event> response = service.getEvents(offset, order);
        assertEquals(event, response);
        verify(repository, never()).findAllByOrderByTimestampAsc(any());
    }

    @Test
    public void shouldBeAbleToRetrieveEventsOrderedByASC() throws Exception {
        String offset = "10";
        String order = "asc";
        Institution owner = new Institution("oi", "123456", "asdasds", "aaaaa", "aaaaaa");
        List<Event> event = Arrays.asList(new Event("name", owner, 2, LocalDate.now(), "title", "subTitle", "address", LocalDate.now(), "description"));
        when(repository.findAllByOrderByTimestampAsc(any())).thenReturn(event);
        List<Event> response = service.getEvents(offset, order);
        assertEquals(event, response);
        verify(repository, never()).findAllByOrderByTimestampDesc(any());
    }

    @Test(expected = BadRequestException.class)
    public void shouldThrowBadRequestGivenNoOrderMatch() throws Exception {
        String offset = "10";
        String order = "dummy";
        service.getEvents(offset, order);
        verify(repository, never()).findAllByOrderByTimestampDesc(any());
        verify(repository, never()).findAllByOrderByTimestampDesc(any());
    }
}