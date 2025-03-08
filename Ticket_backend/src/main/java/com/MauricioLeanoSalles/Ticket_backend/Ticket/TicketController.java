package com.MauricioLeanoSalles.Ticket_backend.Ticket;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
@AllArgsConstructor
public class TicketController {

    private final TicketService service;

    @PostMapping
    public ResponseEntity<Ticket> bookTicket(@RequestBody TicketRequest request){

        if(!service.eventExist(request.getEventId())) return ResponseEntity.status(404).build();

        if(!service.seatsAvailable(request.getEventId())) return ResponseEntity.status(409).build();

        return ResponseEntity.status(201).body(service.createTicket(request));


    }

}
