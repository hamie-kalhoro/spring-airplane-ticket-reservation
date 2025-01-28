package net.hamidz.airTicketReservation.repository;

import net.hamidz.airTicketReservation.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
