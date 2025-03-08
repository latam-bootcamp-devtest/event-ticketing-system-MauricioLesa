package com.MauricioLeanoSalles.Ticket_backend.Ticket;


import com.MauricioLeanoSalles.Ticket_backend.Event.Event;
import com.MauricioLeanoSalles.Ticket_backend.Event.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketRepository repository;
    private final EventRepository eventRepository;

    public boolean ticketExist(int ticketId){
        return repository.findById(ticketId).isPresent();
    }

    public boolean pastEvent(int ticketId){
        int eventId = repository.findById(ticketId).get().getEventId();
        Date now = new Date();
        return now.after(eventRepository.findById(eventId).get().getDate());
    }

    public void deleteTicket(int ticketId){
        Event event = findEventTicket(ticketId);
        repository.delete(repository.findById(ticketId).get());
        event.setAvailableSeats(event.getAvailableSeats()+1);
    }

    public Event findEventTicket(int ticketId){
        return eventRepository.findById(repository.findById(ticketId).get().getEventId()).get();
    }


    public Ticket createTicket(TicketRequest request){

        Event event = eventRepository.findById(request.getEventId()).get();

        event.setAvailableSeats(event.getAvailableSeats()-1);


        return repository.save(new Ticket(request));

    }

}
