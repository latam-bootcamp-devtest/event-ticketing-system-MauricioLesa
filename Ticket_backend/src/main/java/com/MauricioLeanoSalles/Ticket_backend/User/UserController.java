package com.MauricioLeanoSalles.Ticket_backend.User;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/{userId}/tickets")
    public ResponseEntity<Page<TicketHistory>> bookingHistory(@RequestBody HistoryRequest request, @PathVariable int userId){
        Page<TicketHistory> page = service.findHistory(request, userId);
        return ResponseEntity.ok(page);
    }
}
