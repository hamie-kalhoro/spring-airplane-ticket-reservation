package net.hamidz.airTicketReservation.service;

import net.hamidz.airTicketReservation.entity.Ticket;
import net.hamidz.airTicketReservation.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    TicketRepository ticketRepository;
    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void createTicket(Ticket ticket) {
        try {
            ticket.setTicketAllocationDate(LocalDateTime.now());
            ticketRepository.save(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error occured during ticket creation !!!");
        }
    }

    public List<Ticket> findAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("ticket not found!"));
        return ticket;
    }

    public void deleteTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new RuntimeException("ticket not found!"));
        if(ticket != null && !ticket.equals("")) {
            ticketRepository.delete(ticket);
        } else {
            throw new RuntimeException("invalid ticket found!");
        }
    }
}
