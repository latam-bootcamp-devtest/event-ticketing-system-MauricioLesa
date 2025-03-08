package com.MauricioLeanoSalles.Ticket_backend.Ticket;


import com.MauricioLeanoSalles.Ticket_backend.Event.Event;
import com.MauricioLeanoSalles.Ticket_backend.Event.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketService {

    private final TicketRepository repository;
    private final EventRepository eventRepository;



    public Ticket createTicket(TicketRequest request){

        Event event = eventRepository.findById(request.getEventId()).get();

        event.setAvailableSeats(event.getAvailableSeats()-1);


        return repository.save(new Ticket(request));

    }

}
