package net.hamidz.airTicketReservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AirTicketReservation {

	public static void main(String[] args) {
		SpringApplication.run(AirTicketReservation.class, args);
	}

	@GetMapping()
	public String check() {
		return "100%, OK!";
	}
}
