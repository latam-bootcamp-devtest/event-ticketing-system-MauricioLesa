package com.MauricioLeanoSalles.Ticket_backend.Event;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService {

    final private EventRepository repository;

    public Event createEvent(EventRequest request){

        Event eventRequest = new Event(request);

        return repository.save(eventRequest);

    }

    public Page<Event> getEvents(int page, int pagesize) {
        return repository.findAll(Pageable.ofSize(pagesize).withPage(page) );
    }
}
