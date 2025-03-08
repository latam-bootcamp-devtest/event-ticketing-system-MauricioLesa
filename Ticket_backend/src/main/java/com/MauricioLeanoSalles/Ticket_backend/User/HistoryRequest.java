package com.MauricioLeanoSalles.Ticket_backend.User;

import lombok.Data;

import java.util.Date;

@Data
public class HistoryRequest {

    private int page;

    private int pageSize;

    private Date startDate;

    private Date endDate;

    private boolean sort;

    private String search = "";

}
