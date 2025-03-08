package com.MauricioLeanoSalles.Ticket_backend.Ticket;

import lombok.Data;

@Data
public class TicketRequest {

    private int userId;

    private int eventId;
}
