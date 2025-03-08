package com.MauricioLeanoSalles.Ticket_backend.Event;

import lombok.Data;

import java.util.Date;

@Data
public class EventRequest {
    private String name;

    private Date date;

    private int availableSeats;
}
