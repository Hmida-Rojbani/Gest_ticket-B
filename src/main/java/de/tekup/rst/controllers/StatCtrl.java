package de.tekup.rst.controllers;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.rst.services.StatService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class StatCtrl {
	
	private StatService statService;
	
	@GetMapping("/api/stats/client/jour/{id}")
	public String jourClient(@PathVariable int id) {
		return statService.clientJour(id);
	}

}
