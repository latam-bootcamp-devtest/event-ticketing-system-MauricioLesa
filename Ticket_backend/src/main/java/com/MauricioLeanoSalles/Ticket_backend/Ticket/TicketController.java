package com.MauricioLeanoSalles.Ticket_backend.Ticket;


import com.MauricioLeanoSalles.Ticket_backend.Event.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketController {

    private final TicketService service;
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Ticket> bookTicket(@RequestBody TicketRequest request){

        if(!eventService.eventExist(request.getEventId())) return ResponseEntity.status(404).build();

        if(!eventService.seatsAvailable(request.getEventId())) return ResponseEntity.status(409).build();

        return ResponseEntity.status(201).body(service.createTicket(request));

    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<Ticket> deleteTicket(@PathVariable int ticketId){

        if(!service.ticketExist(ticketId)) return ResponseEntity.status(404).build();

        if(service.pastEvent(ticketId)) return ResponseEntity.status(400).build();

        service.deleteTicket(ticketId);
        return ResponseEntity.status(204).build();


    }


}
