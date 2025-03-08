package com.MauricioLeanoSalles.Ticket_backend.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Entity
@IdClass(DTO.class)
@AllArgsConstructor
public class TicketHistory {
    @Id
    private int ticket_id;
    @Id
    private int event_id;
    @Id
    private int user_id;
    private String name;
    private Date date;
}

class DTO {
    private int ticket_id;
    private int event_id;
    private int user_id;


    public DTO(int ticket_id,int event_id, int user_id) {
        this.ticket_id = ticket_id;
        this.event_id = event_id;
        this.user_id = user_id;
    }
}

