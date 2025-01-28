package net.hamidz.airTicketReservation.service;

import net.hamidz.airTicketReservation.entity.Ticket;
import net.hamidz.airTicketReservation.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}
