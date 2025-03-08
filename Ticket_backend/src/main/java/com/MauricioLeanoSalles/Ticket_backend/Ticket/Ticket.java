package com.MauricioLeanoSalles.Ticket_backend.Ticket;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketId;

    private int userId;

    private int eventId;

    public Ticket(TicketRequest request) {

        this.eventId = request.getEventId();
        this.userId = request.getUserId();

    }
}
