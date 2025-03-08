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
    public ResponseEntity<HistoryResponse> bookingHistory(@RequestBody HistoryRequest request, @PathVariable int userId){

        Page<TicketHistory> page = service.findHistory(request, userId);

        HistoryResponse response = HistoryResponse.builder()
                .currentPage(page.getNumber())
                .totalPages(page.getTotalPages())
                .pageSize(page.getSize())
                .events(page.getContent())
                .build();

        return ResponseEntity.ok(response);
    }
}
