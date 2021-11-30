package de.tekup.rst.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.rst.dto.models.TicketDTO;
import de.tekup.rst.services.TicketService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TicketCtrl {
	
	private TicketService ticketService;
	
	@PostMapping("/api/tickets")
	public double saveTicket(@RequestBody TicketDTO ticketDTO) {
		return ticketService.createTicket(ticketDTO);
	}

}
