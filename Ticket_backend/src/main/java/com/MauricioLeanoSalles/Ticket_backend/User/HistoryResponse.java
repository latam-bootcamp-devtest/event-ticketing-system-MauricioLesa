package com.MauricioLeanoSalles.Ticket_backend.User;

import com.MauricioLeanoSalles.Ticket_backend.Event.Event;
import org.springframework.data.domain.Page;

import java.util.List;

public class HistoryResponse {
    private int currentPage;

    private int pageSize;

    private int totalPages;

    private List<TicketHistory> events;

    public HistoryResponse(Page<TicketHistory> events) {
        this.currentPage = events.getPageable().getPageNumber();
        this.pageSize = events.getPageable().getPageSize();
        this.totalPages = events.getTotalPages();
        this.events = events.getContent();
    }
}
