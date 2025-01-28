package net.hamidz.airTicketReservation.controller;

import net.hamidz.airTicketReservation.entity.Ticket;
import net.hamidz.airTicketReservation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets/")
public class TicketController {

    TicketService ticketService;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/create-ticket")
    public ResponseEntity<?> addTicket(@RequestBody Ticket ticket) {
        ticketService.createTicket(ticket);
        return new ResponseEntity<>("ticket created!", HttpStatus.CREATED);
    }

    @GetMapping("/get-all-tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return new ResponseEntity<>(ticketService.findAllTickets(), HttpStatus.FOUND);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        return new ResponseEntity<>(ticketService.getById(id), HttpStatus.FOUND);
    }

}
