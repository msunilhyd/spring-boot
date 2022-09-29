package com.example.springbootmysql.controller;

import com.example.springbootmysql.dao.TicketDao;
import com.example.springbootmysql.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketDao dao;

    @PostMapping("/bookTickets")
    public String bookTicket(@RequestBody Ticket ticket) {
        dao.save(ticket);
        List<Ticket> ticketList = dao.findAll();
        return "ticket booked: " + ticketList.size();
    }

    @GetMapping("/getTickets")
    public List<Ticket> getTickets() {
        return (List<Ticket>) dao.findAll();
    }
}
