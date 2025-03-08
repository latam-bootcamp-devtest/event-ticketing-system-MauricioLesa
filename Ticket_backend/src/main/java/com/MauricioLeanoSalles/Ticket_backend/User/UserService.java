package com.MauricioLeanoSalles.Ticket_backend.User;


import com.MauricioLeanoSalles.Ticket_backend.Event.EventRepository;
import com.MauricioLeanoSalles.Ticket_backend.Ticket.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final TicketRepository repository;

    public Page<TicketHistory>  findHistory(HistoryRequest request, int userId){

        return repository.findTicketHistory(
                request.getStartDate(),
                request.getEndDate(),
                request.getSearch(),
                userId,
                Pageable.ofSize(request.getPageSize()).withPage(request.getPage()));


    }

}
