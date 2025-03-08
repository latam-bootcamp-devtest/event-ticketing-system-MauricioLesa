package com.MauricioLeanoSalles.Ticket_backend.Ticket;

import com.MauricioLeanoSalles.Ticket_backend.User.TicketHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query(
            value = "select new TicketHistory( t.ticketId, t.eventId, t.userId, e.name, e.date) \n" +
                    "from Ticket t, Event e \n" +
                    "where e.date > ?1 and e.date < ?2 and t.eventId = e.eventId and  e.name like %?3% and t.userId = ?4"
    )
    Page<TicketHistory> findTicketHistory(Date before,Date after,String name, int userId, Pageable pageable);
}
