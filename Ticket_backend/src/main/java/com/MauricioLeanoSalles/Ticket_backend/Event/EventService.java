package com.MauricioLeanoSalles.Ticket_backend.Event;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class EventService {

    final private EventRepository repository;

    public Event createEvent(EventRequest request){
        Event eventRequest = new Event(request);
        return repository.save(eventRequest);
    }

    public boolean eventExist(int eventId){
        return repository.findById(eventId).isPresent();
    }

    public boolean seatsAvailable(int eventId){
        return repository.findById(eventId).get().getAvailableSeats() > 0;
    }

    public Page<Event> getEvents(int page, int pagesize) {
        Date date = new Date();
        return repository.findByDateAfterOrderByDate(date, Pageable.ofSize(pagesize).withPage(page));
    }
}
