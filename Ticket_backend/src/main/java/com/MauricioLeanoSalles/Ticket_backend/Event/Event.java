package com.MauricioLeanoSalles.Ticket_backend.Event;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventId;

    private String name;

    private Date date;

    private int availableSeats;

    public Event(EventRequest request) {

        name = request.getName();
        date = request.getDate();
        availableSeats = request.getAvailableSeats();

    }
}
