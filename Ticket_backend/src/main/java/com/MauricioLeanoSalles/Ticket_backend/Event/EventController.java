package com.MauricioLeanoSalles.Ticket_backend.Event;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {

    final EventService eventService;

    @PostMapping
    public ResponseEntity<Event> saveEvent(@RequestBody EventRequest request){

        Event event = eventService.createEvent(request);

        return ResponseEntity.ok(event);
    }

    @GetMapping
    public ResponseEntity<EventPageListResponse> saveEvent(@RequestParam int page, @RequestParam int pagesize){

        Page<Event> events = eventService.getEvents(page, pagesize);



        return ResponseEntity.ok(new EventPageListResponse(events));
    }
}
