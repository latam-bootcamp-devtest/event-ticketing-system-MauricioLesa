package com.MauricioLeanoSalles.Ticket_backend.Event;

import jakarta.annotation.Nonnull;
import lombok.Data;

import java.util.Date;

@Data
public class EventRequest {
    @Nonnull
    private String name;

    @Nonnull
    private Date date;

    @Nonnull
    private int availableSeats;
}
