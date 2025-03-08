package com.MauricioLeanoSalles.Ticket_backend.Event;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class EventPageListResponse {
    private int currentPage;

    private int pageSize;

    private int totalPages;

    private List<Event> events;

    public EventPageListResponse(Page<Event> events) {
        this.currentPage = events.getPageable().getPageNumber();
        this.pageSize = events.getPageable().getPageSize();
        this.totalPages = events.getTotalPages();
        this.events = events.getContent();
    }
}
