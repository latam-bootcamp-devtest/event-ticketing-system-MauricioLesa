package com.MauricioLeanoSalles.Ticket_backend.Event;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class EventService {

    @Autowired
    private EventRepository repository;

    public Event createEvent(EventRequest request){

        Event eventRequest = new Event(request);

        return repository.save(eventRequest);

    }

}
