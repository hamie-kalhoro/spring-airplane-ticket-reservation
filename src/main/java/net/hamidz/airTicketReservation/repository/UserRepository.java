package net.hamidz.airTicketReservation.repository;

import net.hamidz.airTicketReservation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
