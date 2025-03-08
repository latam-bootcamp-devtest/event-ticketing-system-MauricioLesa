package com.MauricioLeanoSalles.Ticket_backend.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    Page<Event> findByDateAfterOrderByDate(Date date, Pageable pageable);




}
