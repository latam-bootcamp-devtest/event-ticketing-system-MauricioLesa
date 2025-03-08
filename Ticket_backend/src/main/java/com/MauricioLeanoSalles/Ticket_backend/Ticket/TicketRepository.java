package com.MauricioLeanoSalles.Ticket_backend.Ticket;

import com.MauricioLeanoSalles.Ticket_backend.User.TicketHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query(
            value = "select t.ticket_id, t.event_id, t.user_id, e.name, e.date\n" +
                    "from ticket t, event e \n" +
                    "t.event_id = e.event_id and e.name like ?1 and t.user_id = ?2",
            nativeQuery = true)
    Page<TicketHistory> findHistory(String name,int userId, Pageable pageable);
}
