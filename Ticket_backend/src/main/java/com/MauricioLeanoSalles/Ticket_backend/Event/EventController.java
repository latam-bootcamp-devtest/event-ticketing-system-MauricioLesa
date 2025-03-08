package com.MauricioLeanoSalles.Ticket_backend.Event;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {

    final EventService eventService;

    @PostMapping
    public ResponseEntity<Event> saveEvent(@RequestBody EventRequest request){

        Date current = new Date();

        if(request.getAvailableSeats() < 1 || !current.before(request.getDate())){
            return ResponseEntity.status(409).build();
        }
        
        Event event = eventService.createEvent(request);

        return ResponseEntity.status(201).body(event);
    }

    @GetMapping
    public ResponseEntity<EventPageListResponse> saveEvent(@RequestParam int page, @RequestParam int pagesize){

        Page<Event> events = eventService.getEvents(page, pagesize);



        return ResponseEntity.ok(new EventPageListResponse(events));
    }
}
